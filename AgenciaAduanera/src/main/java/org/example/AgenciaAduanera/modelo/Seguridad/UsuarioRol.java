package org.example.AgenciaAduanera.modelo.Seguridad;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.View;
import org.openxava.annotations.Views;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuariorol",
        uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "rol_id"}))
@Getter
@Setter
@Views({
        @View(name = "Simple", members =
                "usuario;" +
                        "rol;" +
        "asignacionFecha;"),
        @View(name = "init", members =
                "usuario;" +
                        "rol;" +
        "asignacionFecha;"),
        @View(members =
                "usuario;" +
                        "rol;" +
        "asignacionFecha;")
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

    private LocalDate asignacionFecha;

}

