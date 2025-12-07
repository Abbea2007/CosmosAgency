/*package org.example.AgenciaAduanera.modelo;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.util.CurrentSucursal;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;

@MappedSuperclass
@FilterDef(
        name="sucursalFilter",
        parameters=@ParamDef(name="sucursalId", type="long")
)
@Filter(name="sucursalFilter", condition="sucursal_id = :sucursalId")
@Getter
@Setter
public class SucursalEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sucursal_id")
    private Sucursal sucursal;

    @PrePersist
    public void asignarSucursal() {
        if (sucursal == null && CurrentSucursal.get() != null) {
            this.sucursal = CurrentSucursal.get();
        }
    }
}*/
