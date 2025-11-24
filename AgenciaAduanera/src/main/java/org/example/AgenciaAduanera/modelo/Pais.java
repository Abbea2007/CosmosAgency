package org.example.AgenciaAduanera.modelo;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.View;
import org.openxava.annotations.Views;

import javax.persistence.*;

@Entity
@Table(name = "pais")
@Getter
@Setter
@Views({
        @View(name = "Simple", members = "nombrepais;"),
        @View(name = "init", members = "nombrepais;"),
        @View(members = "nombrepais;")
})
public class Pais extends BaseEntity {

    @Column(length = 50)
    private String nombrepais;
}
