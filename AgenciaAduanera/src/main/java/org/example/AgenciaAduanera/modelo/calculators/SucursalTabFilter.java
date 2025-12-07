/*package org.example.AgenciaAduanera.modelo.calculators;

import org.example.AgenciaAduanera.modelo.util.CurrentSucursal;
import org.openxava.filters.TabFilter;

import javax.persistence.Query;

public class SucursalTabFilter implements TabFilter {

    @Override
    public String filter(String hql) throws Exception {
        // Central ve todo
        if (CurrentSucursal.get() == null || CurrentSucursal.get().getCentral()) return hql;

        String condition = " e.sucursal.id = :sucursalId ";
        String lower = hql.toLowerCase();

        if (lower.contains(" where ")) {
            int orderByPos = lower.lastIndexOf(" order by ");
            if (orderByPos > -1) {
                return hql.substring(0, orderByPos) + " and " + condition + hql.substring(orderByPos);
            }
            return hql + " and " + condition;
        }
        return hql + " where " + condition;
    }

    @Override
    public void setParameters(Query query) throws Exception {
        if (CurrentSucursal.get() != null && !CurrentSucursal.get().getCentral()) {
            query.setParameter("sucursalId", CurrentSucursal.get().getId());
        }
    }
}*/