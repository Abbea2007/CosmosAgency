package org.example.AgenciaAduanera.modelo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Impuesto extends BaseEntity {

    private String nombre;
    private Double porcentaje;

}
