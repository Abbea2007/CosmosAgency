package org.example.AgenciaAduanera.modelo.seguridad;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.openxava.annotations.Required;
import org.openxava.annotations.View;
import org.openxava.annotations.Views;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rol")
@Getter
@Setter
public class Rol extends BaseEntity {

    @Required
    private String nombre;

    @ManyToMany
    @JoinTable(
            name = "rol_vista",
            joinColumns = @JoinColumn(name = "rol_id"),
            inverseJoinColumns = @JoinColumn(name = "vista_id")
    )
    private Set<Vista> vistas = new HashSet<>();;
}
