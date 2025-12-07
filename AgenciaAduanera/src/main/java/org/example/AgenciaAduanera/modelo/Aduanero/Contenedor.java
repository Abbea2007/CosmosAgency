package org.example.AgenciaAduanera.modelo.Aduanero;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
//import org.example.AgenciaAduanera.modelo.SucursalEntity;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.View;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@View( members = "codigo; " +
        "tipo; " +
        "capacidad; ")

public class Contenedor extends BaseEntity {

    private String codigo;
    private String tipo;
    private Double capacidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "declaracion_id")
    private Declaracion declaracion;
}
