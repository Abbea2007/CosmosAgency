package org.example.AgenciaAduanera.modelo;


import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;

import javax.persistence.*;

@Entity
@Table(name = "municipio")
@Getter
@Setter
public class Municipio extends BaseEntity{

    private String nombreMunicipio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pais_id")
    @DescriptionsList(descriptionProperties="nombrepais")
    private Pais pais;

}
