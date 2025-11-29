package org.example.AgenciaAduanera.modelo.Catalogos;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;


@Entity
@Getter
@Setter

public class Remitente extends BaseEntity {

    private String nombre;
    private String telefono;

    @Embedded
    private Direccion direccion;



}
