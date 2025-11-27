package org.example.AgenciaAduanera.modelo.Seguridad;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.example.AgenciaAduanera.modelo.Estado;
import org.example.AgenciaAduanera.modelo.Sucursal;
import org.openxava.annotations.*;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@Views({
        @View(name = "Simple", members =
                "username;" +
                        "password;" +
                        "nombre;" +
                        "email;" +
                        "sucursal;" +
        "cargo;"),
        @View(name = "init", members =
                "username;" +
                        "password;" +
                        "nombre;" +
                        "email;" +
                        "sucursal;" +
        "cargo;"),
        @View(members =
                "username;" +
                        "password;" +
                        "nombre;" +
                        "email;" +
                        "sucursal;" +
        "cargo;")
})
public class Usuario extends BaseEntity {

    @Required
    private String username;
    private String password;

    @Required
    private String nombre;

    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sucursal_id")
    @DescriptionsList(descriptionProperties = "nombre")
    private Sucursal sucursal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargo_id")
    @DescriptionsList(descriptionProperties = "nombreCargo")
    private Cargo cargo;



}
