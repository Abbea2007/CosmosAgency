package org.example.AgenciaAduanera.modelo.Catalogos;


import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.openxava.annotations.Required;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "unidad_medida")
@Getter
@Setter

public class UnidadMedida extends BaseEntity {


    @Required
    private String nombreUnidad;
    @Required
    private String abreviatura;
}
