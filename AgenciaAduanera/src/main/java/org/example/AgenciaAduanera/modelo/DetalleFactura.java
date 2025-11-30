package org.example.AgenciaAduanera.modelo;


import lombok.Getter;
import lombok.Setter;

import org.openxava.annotations.*;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Embeddable
@Getter
@Setter

public class DetalleFactura {


    @ManyToOne(fetch = FetchType.LAZY)
    private Servicio servicio;


}




