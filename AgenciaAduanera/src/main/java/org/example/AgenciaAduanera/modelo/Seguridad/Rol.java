package org.example.AgenciaAduanera.modelo.Seguridad;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.openxava.annotations.Required;
import org.openxava.annotations.View;
import org.openxava.annotations.Views;

import javax.persistence.*;

@Entity
@Table(name = "rol")
@Getter
@Setter
@Views({
        @View(name = "Simple", members = "nombre;"),
        @View(name = "init", members = "nombre;"),
        @View(members = "nombre;")
})
public class Rol extends BaseEntity {

    @Required
    private String nombre;
}
