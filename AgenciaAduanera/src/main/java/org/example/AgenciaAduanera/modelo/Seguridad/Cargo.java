package org.example.AgenciaAduanera.modelo.Seguridad;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cargo")
@Getter
@Setter

public class Cargo extends BaseEntity {

    private String nombreCargo;
    private String descripcionCargo;



}
