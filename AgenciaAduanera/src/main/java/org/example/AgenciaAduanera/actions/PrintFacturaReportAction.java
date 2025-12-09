package org.example.AgenciaAduanera.actions;

import java.util.List;
import javax.persistence.EntityManager;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.openxava.actions.JasperReportBaseAction;
import org.openxava.jpa.XPersistence;

import org.example.AgenciaAduanera.modelo.transacciones.Factura;

public class PrintFacturaReportAction extends JasperReportBaseAction {

    @Override
    protected JRDataSource getDataSource() throws Exception {
        EntityManager em = XPersistence.getManager();


        List<Factura> facturas =
                em.createQuery("from Factura", Factura.class).getResultList();

        return new JRBeanCollectionDataSource(facturas);
    }

    @Override
    protected String getJRXML() throws Exception {
        return "ReporteFactura.jrxml";
    }

    @Override
    protected java.util.Map getParameters() throws Exception {
        return null; // Igual que tu amigo: sin parámetros
    }
}
