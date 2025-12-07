/*package org.example.AgenciaAduanera.modelo.util;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import org.example.AgenciaAduanera.modelo.util.CurrentSucursal;
import org.hibernate.Session;
import org.openxava.jpa.XPersistence;

import java.io.IOException;


@WebFilter("/*")
public class SucursalRequestFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        try {
            if (CurrentSucursal.get() != null && !CurrentSucursal.get().getCentral()) {
                Session session = XPersistence.getManager().unwrap(Session.class);
                session.enableFilter("sucursalFilter")
                        .setParameter("sucursalId", CurrentSucursal.get().getId());

                System.out.println("Filtro activado con sucursalId=" + CurrentSucursal.get().getId());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        chain.doFilter(request, response);
    }
}*/