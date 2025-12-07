package org.example.AgenciaAduanera.actions;

import org.example.AgenciaAduanera.modelo.Aduanero.Expediente;
import org.example.AgenciaAduanera.modelo.Catalogos.EstadoExpediente;
import org.openxava.actions.ViewBaseAction;
import org.openxava.jpa.XPersistence;

import java.time.LocalDate;

public class CerrarExpedienteAction extends ViewBaseAction {

    @Override
    public void execute() throws Exception {

        Object id = getView().getValue("id");
        Expediente expediente = XPersistence.getManager().find(Expediente.class, id);

        if (expediente == null) {
            addError("El expediente no existe");
            return;
        }

        if (expediente.getEstadoExpediente().getNombreEstado().equals("Cerrado")) {
            addMessage("El expediente ya está cerrado");
            return;
        }

        // Cambiar estado y fecha cierre
        expediente.setFecha_cierre(LocalDate.now());

        EstadoExpediente cerrado =
                (EstadoExpediente) XPersistence.getManager()
                        .createQuery("from EstadoExpediente e where e.nombreEstado = 'Cerrado'")
                        .getSingleResult();

        expediente.setEstadoExpediente(cerrado);

        XPersistence.getManager().merge(expediente);

        addMessage("Expediente cerrado correctamente");
        getView().refresh();
    }
}