package org.example.AgenciaAduanera.modelo.transacciones;


import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.config.AuditoriaListener;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.example.AgenciaAduanera.modelo.auditoria.Auditable;
import org.example.AgenciaAduanera.modelo.auditoria.Auditoria;
import org.openxava.annotations.Money;
import org.openxava.annotations.TextArea;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@EntityListeners(AuditoriaListener.class)
public class Servicio extends BaseEntity implements Auditable {

    private String numero;
    private String nombreServicio;
    @Money
    private BigDecimal precioServicio;
    @TextArea
    private String obervaciones;

    @Embedded
    private Auditoria auditoria = new Auditoria();

    @Override
    public Auditoria getAuditoria() {
        return auditoria;
    }

    @Override
    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }



}
