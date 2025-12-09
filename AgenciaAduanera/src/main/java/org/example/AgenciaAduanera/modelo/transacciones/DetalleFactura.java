package org.example.AgenciaAduanera.modelo.transacciones;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Embeddable
@Getter
@Setter

public class DetalleFactura {


    @ManyToOne(fetch = FetchType.LAZY)
    private Servicio servicio;


}




