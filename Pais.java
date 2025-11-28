package org.example.orden.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pais")
@Getter
@Setter

//Las relaciones OneToMany a Municipio e ItemDeclaracion ya están declarados
//Están como comentarios hasta que esas tablas sean terminadas

public class Pais extends BaseEntity{
    @Column(name = "nombre_pais", length = 50, nullable = false)
    private String nombrePais;
    //@OneToMany(mappedBy = "paisMunicipio", cascade = CascadeType.ALL)
    //private List<Municipio> municipios;
    //@OneToMany(mappedBy = "paisItemDeclaracion", cascade = CascadeType.ALL)
    //private List<ItemDeclaracion> itemsDeclaracion;
}
