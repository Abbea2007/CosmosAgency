package org.example.AgenciaAduanera.modelo;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.Catalogos.Direccion;
import org.openxava.annotations.Required;
import org.openxava.annotations.View;
import org.openxava.annotations.Views;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@Views({
        @View(name = "Simple", members =
                "nombreCliente;" +
                        "ruc;" +
                        "email;" +
                        "telefono;" +
        "direccion;"),
        @View(name = "init", members =
                "nombreCliente;" +
                        "ruc;" +
                        "email;" +
                        "telefono;" +
        "direccion;"),

        @View(members =
                "nombreCliente;" +
                        "ruc;" +
                        "email;" +
                        "telefono;" +
        "direccion;"),

})
public class Cliente extends BaseEntity {

    @Required
    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Required
    private String ruc;

    @Required
    private String email;

    @Required
    private String telefono;

    @Embedded
    private Direccion direccion;





}
