package org.example.AgenciaAduanera.config;

import org.example.AgenciaAduanera.annotations.FilterRestrictiva;
import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.hibernate.SessionFactory;

import org.openxava.jpa.XPersistence;
import org.openxava.util.Users;
import org.openxava.util.Is;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Table;
import javax.persistence.Query;
import javax.persistence.metamodel.EntityType;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class RestrictivaStatementInspector implements StatementInspector {

    private volatile Set<String> tablasFiltrables;

    private static final Pattern FROM_JOIN_PATTERN =
            Pattern.compile("(from|join)\\s+([a-zA-Z0-9_]+)\\s+([a-zA-Z0-9_]+)", Pattern.CASE_INSENSITIVE);

    private static final ThreadLocal<Long> sucursalActual = new ThreadLocal<>();
    private static final ThreadLocal<Boolean> resolviendoSucursal =
            ThreadLocal.withInitial(() -> false);

    public RestrictivaStatementInspector() { }

    // ----------------------------------------------
    //  Inicializar tablas con anotación @FilterRestrictiva
    // ----------------------------------------------
    private void inicializarTablasFiltrables() {
        if (tablasFiltrables != null) return;

        synchronized (this) {
            if (tablasFiltrables != null) return;

            EntityManagerFactory emf = XPersistence.getManager().getEntityManagerFactory();
            SessionFactory sf = emf.unwrap(SessionFactory.class);

            tablasFiltrables = sf.getMetamodel()
                    .getEntities()
                    .stream()
                    .map(EntityType::getJavaType)
                    .filter(clazz -> clazz.isAnnotationPresent(FilterRestrictiva.class))
                    .map(clazz -> {
                        Table t = clazz.getAnnotation(Table.class);
                        return t != null ? t.name().toLowerCase() : clazz.getSimpleName().toLowerCase();
                    })
                    .collect(Collectors.toSet());
        }
    }


    // ----------------------------------------------
    //  MÉTODO PRINCIPAL DEL INSPECTOR
    // ----------------------------------------------
    @Override
    public String inspect(String sql) {

        inicializarTablasFiltrables();
        if (sql == null) return sql;

        // Evitar recursión infinita
        if (resolviendoSucursal.get()) return sql;

        String lowerSql = sql.toLowerCase();

        // No tocar INSERT/UPDATE/DELETE
        if (lowerSql.startsWith("insert") || lowerSql.startsWith("update") || lowerSql.startsWith("delete")) {
            return sql;
        }

        // No filtrar consultas que leen usuario (evita recursión)
        if (lowerSql.contains(" from usuario") || lowerSql.contains(" join usuario")) {
            return sql;
        }

        Long sucursalId = obtenerSucursalActual();
        if (sucursalId == null) return sql;

        Map<String, String> aliasFiltrados = extraerAlias(sql);
        if (aliasFiltrados.isEmpty()) return sql;

        String condiciones = aliasFiltrados.values().stream()
                .map(alias -> alias + ".sucursal_id = " + sucursalId)
                .collect(Collectors.joining(" AND "));

        String filtro = "(" + condiciones + ")";

        // ------------------------------------------
        //  INSERTAR FILTRO ANTES DE ORDER BY, LIMIT, OFFSET
        // ------------------------------------------
        int idxOrder = lowerSql.indexOf(" order by ");
        int idxLimit = lowerSql.indexOf(" limit ");
        int idxOffset = lowerSql.indexOf(" offset ");

        // Determinar la primera cláusula final (ORDER, LIMIT u OFFSET)
        int corte = -1;
        if (idxOrder != -1) corte = idxOrder;
        if (idxLimit != -1 && (corte == -1 || idxLimit < corte)) corte = idxLimit;
        if (idxOffset != -1 && (corte == -1 || idxOffset < corte)) corte = idxOffset;

        // Si hay WHERE original:
        if (lowerSql.contains(" where ")) {

            if (corte != -1) {
                // Insertamos antes de ORDER/LIMIT/OFFSET
                String base = sql.substring(0, corte);
                String tail = sql.substring(corte);
                return base + " AND " + filtro + " " + tail;
            }
            else {
                // WHERE sin ORDER/LIMIT/OFFSET
                return sql + " AND " + filtro;
            }
        }
        // No había WHERE original:
        else {

            if (corte != -1) {
                // Insertamos el WHERE ANTES del ORDER/LIMIT/OFFSET
                String base = sql.substring(0, corte);
                String tail = sql.substring(corte);
                return base + " WHERE " + filtro + " " + tail;
            }
            else {
                // No había ningún final
                return sql + " WHERE " + filtro;
            }
        }
    }



    // ----------------------------------------------
    //  BUSCAR LAS TABLAS FILTRABLES EN EL SQL
    // ----------------------------------------------
    private Map<String, String> extraerAlias(String sql) {
        Map<String, String> resultado = new LinkedHashMap<>();
        Matcher m = FROM_JOIN_PATTERN.matcher(sql.toLowerCase());

        while (m.find()) {
            String tabla = m.group(2).toLowerCase();
            String alias = m.group(3);
            if (tablasFiltrables.contains(tabla)) {
                resultado.put(tabla, alias);
            }
        }
        return resultado;
    }


    // ----------------------------------------------
    //   Obtener sucursal del usuario logueado
    // ----------------------------------------------
    private Long obtenerSucursalActual() {

        Long id = sucursalActual.get();
        if (id != null) return id;

        // Evitar recursión: si ya estamos resolviendo, no hacer nada
        if (resolviendoSucursal.get()) return null;

        resolviendoSucursal.set(true);

        try {
            String login = Users.getCurrent();
            if (Is.emptyString(login)) return null;

            // ? SI EL USUARIO ES ADMIN ? NO FILTRAR POR SUCURSAL
            if (login.equalsIgnoreCase("admin")) {
                return null; // Esto hace que en inspect() no se añada el WHERE
            }

            // ? LÓGICA ORIGINAL QUE YA FUNCIONABA
            Query q = XPersistence.getManager()
                    .createQuery("select u.sucursal.id from Usuario u where u.username = :user");
            q.setParameter("user", login);

            id = (Long) q.getSingleResult();
            sucursalActual.set(id);
            return id;

        } catch (Exception ex) {
            return null;

        } finally {
            resolviendoSucursal.set(false);
        }
    }
}