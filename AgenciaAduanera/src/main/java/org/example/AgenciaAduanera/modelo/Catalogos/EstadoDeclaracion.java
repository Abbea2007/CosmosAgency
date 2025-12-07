package org.example.AgenciaAduanera.modelo.Catalogos;


import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
//import org.example.AgenciaAduanera.modelo.SucursalEntity;
import org.openxava.annotations.Required;

import javax.persistence.Entity;

@Entity
@Getter
@Setter

public class EstadoDeclaracion extends BaseEntity {

    @Required
    private String nombre;
    private String descripcion;

}
