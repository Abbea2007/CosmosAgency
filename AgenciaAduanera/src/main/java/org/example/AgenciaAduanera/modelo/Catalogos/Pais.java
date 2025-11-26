package org.example.AgenciaAduanera.modelo.Catalogos;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.View;
import org.openxava.annotations.Views;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pais")
@Getter
@Setter
@Views({
        @View(name = "Simple", members = "nombrepais;" + "municipios"),
        @View(name = "init", members = "nombrepais;" + "municipios"),
        @View(members = "nombrepais;")
})
public class Pais extends BaseEntity {

    @Column(length = 50)
    private String nombrepais;



}
