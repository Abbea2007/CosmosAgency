package org.example.AgenciaAduanera.modelo.Catalogos;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.Required;
import org.openxava.annotations.View;
import org.openxava.annotations.Views;

import javax.persistence.*;

@Entity
@Table(name = "sucursal")
@Getter
@Setter
@View(members = "codigo;" +
                        "nombre;" +
                        "telefono;" +
        "direccion;" +
        "departamento;" +
        "municipio")

public class Sucursal extends BaseEntity {

    @Required
    private String codigo;

    @Required
    private String nombre;


    @Required
    private String telefono;

    @Embedded
    private Direccion direccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departamento_id")
    @DescriptionsList(descriptionProperties = "nombre")
    private Departamento departamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "municipio_id")
    @DescriptionsList(descriptionProperties = "nombre")
    private Municipio municipio;
}
