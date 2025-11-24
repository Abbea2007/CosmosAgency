package org.example.AgenciaAduanera.modelo;

import lombok.Getter;
import lombok.Setter;
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
                        "direccion;" +
                        "telefono;"),
        @View(name = "init", members =
                "codigo;" +
                        "nombre;" +
                        "direccion;" +
                        "telefono;"),
        @View(members =
                "codigo;" +
                        "nombre;" +
                        "direccion;" +
                        "telefono;")
})
public class Sucursal extends BaseEntity {

    @Required
    private String codigo;

    private String nombre;
    private String direccion;
    private String telefono;
}
