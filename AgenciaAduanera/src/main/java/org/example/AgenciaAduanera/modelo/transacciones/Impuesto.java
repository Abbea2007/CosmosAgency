package org.example.AgenciaAduanera.modelo.transacciones;


import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Impuesto extends BaseEntity {

    private String nombre;
    private Double porcentaje;

}
