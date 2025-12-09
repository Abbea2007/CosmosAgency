package org.example.AgenciaAduanera.modelo.transacciones;


import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.openxava.annotations.ReferenceView;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter

public class Pago extends BaseEntity
{
    private LocalDate fechaPago;
    private BigDecimal monto;
    private String metodoPago;
    private String referencia;

    @ManyToOne(fetch = javax.persistence.FetchType.LAZY)
    @ReferenceView("Simple")
    private Factura factura;
}
