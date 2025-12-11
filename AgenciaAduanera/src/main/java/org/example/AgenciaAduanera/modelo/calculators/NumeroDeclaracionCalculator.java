package org.example.AgenciaAduanera.modelo.calculators;

import org.openxava.calculators.ICalculator;
import org.openxava.jpa.XPersistence;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.Year;

public class NumeroDeclaracionCalculator implements ICalculator {

    @Override
    public Object calculate() throws Exception {

        EntityManager em = XPersistence.getManager();

        int anioActual = Year.now().getValue();

        // ==== 1. Buscar el último número del año actual ====
        Query q = em.createQuery(
                "SELECT d.numeroDeclaracion " +
                        "FROM Declaracion d " +
                        "WHERE d.anio = :anio " +
                        "ORDER BY d.numeroDeclaracion DESC"
        );
        q.setParameter("anio", anioActual);
        q.setMaxResults(1);

        String ultimo = null;

        try {
            ultimo = (String) q.getSingleResult();
        } catch (Exception ignored) {
        }

        // ==== 2. Si no hay registros en ese año ? iniciar en DEC-YYYY-001 ====
        if (ultimo == null || ultimo.trim().isEmpty()) {
            return String.format("DEC-%d-%03d", anioActual, 1);
        }

        // ==== 3. Asegurar que el formato trae tres partes ====
        // Formato correcto esperado: DEC-2025-001
        String[] partes = ultimo.split("-");

        if (partes.length != 3) {
            // Si trae DEC-001 o algo extraño ? reiniciar de forma segura
            return String.format("DEC-%d-%03d", anioActual, 1);
        }

        // ==== 4. Extraer el número ====
        int numero;

        try {
            numero = Integer.parseInt(partes[2]);
        } catch (NumberFormatException ex) {
            // Si no es número (ej: "DEC-2025-ABC") ? reiniciar
            return String.format("DEC-%d-%03d", anioActual, 1);
        }

        numero++; // Incrementar

        // ==== 5. Devolver el nuevo número formateado ====
        return String.format("DEC-%d-%03d", anioActual, numero);
    }
}
