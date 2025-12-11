package org.example.AgenciaAduanera.config;

import org.example.AgenciaAduanera.modelo.auditoria.Auditable;
import org.openxava.util.Users;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AuditoriaListener {
    @PrePersist
    public void prePersist(Object auditable) {
        if (auditable instanceof Auditable) {
            Auditable e = (Auditable) auditable;
            // Obtener el nombre del usuario logeado o usar "SYSTEM" si no hay sesión
            String usuario = Users.getCurrent();

            e.getAuditoria().setUsuarioIng(usuario);
            e.getAuditoria().setFechaIng(LocalDateTime.now());
            // También inicializamos los campos de actualización al crear
            e.getAuditoria().setUsuarioAct(usuario);
            e.getAuditoria().setFechaAct(LocalDateTime.now());
        }
    }

    @PreUpdate
    public void preUpdate(Object auditable) {
        if (auditable instanceof Auditable) {
            Auditable e = (Auditable) auditable;
            String usuario = Users.getCurrent();

            e.getAuditoria().setUsuarioAct(usuario);
            e.getAuditoria().setFechaAct(LocalDateTime.now());
        }
    }

}
