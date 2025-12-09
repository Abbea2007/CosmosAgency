package org.example.AgenciaAduanera.actions;

import org.example.AgenciaAduanera.modelo.Aduanero.Declaracion;
import org.example.AgenciaAduanera.modelo.transacciones.DetalleFactura;
import org.example.AgenciaAduanera.modelo.transacciones.Factura;
import org.example.AgenciaAduanera.modelo.transacciones.Servicio;
import org.openxava.actions.ViewBaseAction;
import org.openxava.jpa.XPersistence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class GenerarFacturaAction extends ViewBaseAction {

    @Override
    public void execute() throws Exception {

        Object id = getView().getValue("id");

        if (id == null) {
            addError("Debe grabar la declaración antes de generar factura");
            return;
        }

        Declaracion declaracion = XPersistence.getManager().find(Declaracion.class, id);

        if (declaracion == null) {
            addError("La declaración no existe");
            return;
        }

        if (declaracion.getItems() == null || declaracion.getItems().isEmpty()) {
            addError("La declaración no tiene items, no se puede generar factura");
            return;
        }

        // 1) Calcular total de items
        BigDecimal total = declaracion.getItems()
                .stream()
                .map(i -> i.getBaseImponible())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 2) Crear servicio único para la factura
        Servicio servicio = new Servicio();
        servicio.setNumero("SRV-" + declaracion.getId());
        servicio.setNombreServicio("Servicio aduanero por declaración");
        servicio.setPrecioServicio(total);
        XPersistence.getManager().persist(servicio);

        // 3) Crear detalle factura
        DetalleFactura detalle = new DetalleFactura();
        detalle.setServicio(servicio);

        // 4) Crear factura completa
        Factura factura = new Factura();
        factura.setAnio(LocalDate.now().getYear());
        factura.setFecha(LocalDate.now());
        factura.setCliente(declaracion.getExpediente().getCliente());
        factura.setDetalleFacturas(new ArrayList<>());
        factura.getDetalleFacturas().add(detalle);

        factura.setPorcentajeIva(new BigDecimal("15"));

        XPersistence.getManager().persist(factura);

        addMessage("Factura generada correctamente para el cliente: "
                + declaracion.getExpediente().getCliente().getNombreCliente());

        getView().refresh();
    }
}
