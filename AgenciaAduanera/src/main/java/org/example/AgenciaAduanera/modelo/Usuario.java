package org.example.AgenciaAduanera.modelo;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.Required;
import org.openxava.annotations.View;
import org.openxava.annotations.Views;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@Views({
        @View(name = "Simple", members =
                "username;" +
                        "nombre;" +
                        "email;" +
                        "estado;" +
                        "sucursal;"),
        @View(name = "init", members =
                "username;" +
                        "nombre;" +
                        "email;" +
                        "estado;" +
                        "sucursal;"),
        @View(members =
                "username;" +
                        "nombre;" +
                        "email;" +
                        "estado;" +
                        "sucursal;")
})
public class Usuario extends BaseEntity {

    @Required
    private String username;

    @Required
    private String nombre;

    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sucursal_id")
    @DescriptionsList(descriptionProperties = "nombre")
    private Sucursal sucursal;

    @Required
    @Enumerated(EnumType.STRING)
    private Estado estado;
}
