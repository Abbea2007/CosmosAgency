package org.example.AgenciaAduanera.modelo.Catalogos;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "estado_expediente")
@Getter
@Setter

public class EstadoExpediente extends BaseEntity {

    private String nombreEstado;
    private String descripcionEstado;
}
