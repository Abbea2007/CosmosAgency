package org.example.AgenciaAduanera.modelo.Catalogos;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
//mport org.example.AgenciaAduanera.modelo.SucursalEntity;
import org.openxava.annotations.Required;

import javax.persistence.Entity;


@Entity
@Getter
@Setter

public class MedioTransporte extends BaseEntity
{
    @Required
    private String nombre;
}
