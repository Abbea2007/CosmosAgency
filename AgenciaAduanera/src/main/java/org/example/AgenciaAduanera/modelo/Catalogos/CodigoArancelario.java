package org.example.AgenciaAduanera.modelo.Catalogos;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;

import javax.persistence.Entity;


@Entity
@Getter
@Setter

public class CodigoArancelario extends BaseEntity {

    private String codigo;
    private String descripcion;
}
