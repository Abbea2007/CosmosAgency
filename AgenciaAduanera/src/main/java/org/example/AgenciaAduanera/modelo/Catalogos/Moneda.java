package org.example.AgenciaAduanera.modelo.Catalogos;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.openxava.annotations.View;
import org.openxava.annotations.Views;

import javax.persistence.*;

@Entity
@Table(name = "moneda")
@Getter
@Setter
@Views({
        @View(name = "Simple", members = "nombremoneda;"),
        @View(name = "init", members = "nombremoneda;"),
        @View(members = "nombremoneda;")
})
public class Moneda extends BaseEntity {

    @Column(length = 50)
    private String nombremoneda;
}
