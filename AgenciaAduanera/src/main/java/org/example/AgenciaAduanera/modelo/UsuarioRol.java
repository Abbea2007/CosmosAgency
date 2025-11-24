package org.example.AgenciaAduanera.modelo;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.View;
import org.openxava.annotations.Views;

import javax.persistence.*;

@Entity
@Table(name = "usuariorol",
        uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "rol_id"}))
@Getter
@Setter
@Views({
        @View(name = "Simple", members =
                "usuario;" +
                        "rol;"),
        @View(name = "init", members =
                "usuario;" +
                        "rol;"),
        @View(members =
                "usuario;" +
                        "rol;")
})
public class UsuarioRol extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @DescriptionsList(descriptionProperties="nombre")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id")
    @DescriptionsList(descriptionProperties="nombre")
    private Rol rol;
}

