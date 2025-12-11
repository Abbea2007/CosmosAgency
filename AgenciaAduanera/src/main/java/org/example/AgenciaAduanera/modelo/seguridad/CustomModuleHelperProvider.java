package org.example.AgenciaAduanera.modelo.seguridad;

import com.openxava.naviox.Modules;
import com.openxava.naviox.impl.MetaModuleFactory;
import com.openxava.naviox.impl.ModulesHelperProvider;
import org.openxava.application.meta.MetaModule;
import org.openxava.jpa.XPersistence;
import org.openxava.util.Users;

import javax.persistence.Query;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomModuleHelperProvider extends ModulesHelperProvider {

    public void init(String applicationName) {
        // No se necesita inicialización adicional
    }

    public String getCurrent(HttpServletRequest request) {
        return null; // No necesitamos definir el módulo actual
    }

    /** Módulo al que pueden acceder los usuarios sin login (por ejemplo, SignIn) */
    public String getUserAccessModule(ServletRequest request) {
        return "SignIn";
    }

    /** Retorna todos los módulos visibles para el usuario actual */
    public List<MetaModule> getAll(HttpServletRequest request) {
        if (Users.getCurrent() == null) return Collections.emptyList();
        return createAll();
    }

    /** No mostramos módulos fuera del menú */
    public List<MetaModule> getNotInMenu() {
        return Collections.emptyList();
    }

    /**
     * Crea la lista de módulos visibles según el rol y las vistas permitidas del usuario.
     */
    private List<MetaModule> createAll() {
        String user = Users.getCurrent();
        System.out.println(user);
        Query query = XPersistence.getManager().createQuery(
                "SELECT v.nombreVista " +
                        "FROM Usuario u " +
                        "JOIN u.rol.vistas v " +
                        "WHERE u.username = :user");
        query.setParameter("user", user);
        List<String> vistasPermitidas = query.getResultList();
        List<MetaModule> result = new ArrayList<MetaModule>();
        if(user.equals("admin")){
            for (MetaModule module: MetaModuleFactory.createAll()) {
                System.out.println(module.getName());
                if (module.getName().equals("SignIn")) continue;
                if (module.getName().equals("DiscussionComment")) continue;
                result.add(module);
            }
        }else{
            for (MetaModule module: MetaModuleFactory.createAll()) {
                System.out.println(module.getName());
                if (module.getName().equals("SignIn")) continue;
                if (module.getName().equals("DiscussionComment")) continue;
                if (!vistasPermitidas.contains(module.getName())) continue;
                result.add(module);
            }
        }

        return result;
    }

    public boolean isPublic(HttpServletRequest request, String moduleName) {
        return Modules.FIRST_STEPS.equals(moduleName);
    }


    public boolean showsIndexLink() {
        return false;
    }


    public boolean showsSearchModules(HttpServletRequest request) {
        Modules modules = (Modules) request.getSession().getAttribute("modules");
        return modules.getAll(request).size() > 30;
    }


    public Collection<MetaModule> getInMenu(HttpServletRequest request, Modules modules) {
        if ("true".equals(request.getParameter("fixedModules"))) {
            return modules.getFixedModules(request);
        }
        if ("true".equals(request.getParameter("bookmarkModules"))) {
            return modules.getBookmarkModules(request);
        }
        return modules.getRegularModules(request);
    }
}