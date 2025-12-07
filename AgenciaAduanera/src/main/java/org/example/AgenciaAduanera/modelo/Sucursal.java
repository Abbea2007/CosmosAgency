package org.example.AgenciaAduanera.modelo;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.Catalogos.Direccion;
import org.openxava.annotations.Required;
import org.openxava.annotations.View;
import org.openxava.annotations.Views;

import javax.persistence.*;

@Entity
@Table(name = "sucursal")
@Getter
@Setter
@Views({
        @View(name = "Simple", members =
                "codigo;" +
                        "nombre;" +
                        "telefono;" +
        "direccion;"),
        @View(name = "init", members =
                "codigo;" +
                        "nombre;" +
                        "telefono;" +
        "direccion;"),
        @View(members =
                "codigo;" +
                        "nombre;" +
                        "telefono;" +
        "direccion;"),
})
public class Sucursal extends BaseEntity {

    @Required
    private String codigo;

    @Required
    private String nombre;

    private Boolean central = Boolean.FALSE;


    @Required
    private String telefono;

    @Embedded
    private Direccion direccion;
}
