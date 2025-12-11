package org.example.AgenciaAduanera.actions;

import org.example.AgenciaAduanera.modelo.seguridad.Usuario;
import org.openxava.actions.CreateNewFromReferenceAction;
import org.openxava.jpa.XPersistence;
import org.openxava.util.Users;

public class NewCreateFromReference extends CreateNewFromReferenceAction {

    @Override
    public void execute() throws Exception {
        String user = Users.getCurrent();
        Usuario usuario = XPersistence.getManager()
                .createQuery("SELECT u FROM Usuario u WHERE u.username = :user", Usuario.class)
                .setParameter("user", user)
                .getSingleResult();

        boolean permitido = usuario.getRol().getVistas()
                .stream()
                .anyMatch(v -> v.getNombreVista().equals(getModelName()));

        if (permitido) {
            super.execute();
        } else {
            addError("No tiene permisos para crearlo");
        }
    }
}