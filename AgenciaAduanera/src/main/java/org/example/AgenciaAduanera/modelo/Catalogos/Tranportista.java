package org.example.AgenciaAduanera.modelo.Catalogos;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.openxava.annotations.Required;

import javax.persistence.Entity;

@Entity
@Getter
@Setter

public class Tranportista extends BaseEntity {

    @Required
    private String nombre;
    private String tipo;
    @Required
    private String numeroIdentificacion;
    @Required
    private String telefono;

}
