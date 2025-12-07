package org.example.AgenciaAduanera.modelo.Catalogos;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
//import org.example.AgenciaAduanera.modelo.SucursalEntity;
import org.openxava.annotations.Required;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@Getter
@Setter

public class Consignatario extends BaseEntity {

    @Required
    private String nombre;
    @Required
    private String telefono;
    @Embedded
    private Direccion direccion;


}
