package org.example.AgenciaAduanera.modelo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
@Getter
@Setter
public class DetalleFactura {

    int cantidad;

    @ManyToOne(fetch = javax.persistence.FetchType.LAZY)
    private Servicio servicio;

}
