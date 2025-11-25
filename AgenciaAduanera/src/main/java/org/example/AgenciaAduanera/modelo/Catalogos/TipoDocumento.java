package org.example.AgenciaAduanera.modelo.Catalogos;


import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_documento")
@Getter
@Setter
public class TipoDocumento extends BaseEntity {

    private String nombreTipoDocumento;
    private String descripcion;
}
