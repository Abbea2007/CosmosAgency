/*package org.example.AgenciaAduanera.modelo.calculators;


import org.openxava.util.Messages;
import org.openxava.util.Users;
import org.openxava.validators.IValidator;


public class ValidadorCambioActivo  implements IValidator {

    private boolean activo;

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public void validate(Messages value) throws Exception {

        if (!this.activo) {
            // Lógica para validar cuando se cambia a activo

        } if (!Users.hasRole("ADMIN")) {

            errors.add("Solo los administradores pueden cambiar el estado a inactivo.");
            // Lógica para validar cuando se cambia a inactivo

        }

    }
}*/
