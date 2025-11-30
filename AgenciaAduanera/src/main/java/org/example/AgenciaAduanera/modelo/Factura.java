package org.example.AgenciaAduanera.modelo;


import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.calculators.CalcularNumero;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentYearCalculator;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Getter
@Setter
@Views({

        @View(name = "Simple", members =
                "id, anio, numero, fecha; "),
        @View(members =
        "anio, numero, fecha; "+
        "cliente; "+
        "detalleFacturas; "+
        "subTotal, iva, total; "+
        "obervaciones")
        })

public class Factura extends BaseEntity{


    @DefaultValueCalculator(CurrentYearCalculator.class)
    private int anio;
    @DefaultValueCalculator(value = CalcularNumero.class, properties = @PropertyValue(name = "anio"))
    private int numero;
    @DefaultValueCalculator(CurrentYearCalculator.class)
    private LocalDate fecha;

    @ManyToOne(fetch = javax.persistence.FetchType.LAZY, optional = false)
    @ReferenceView("Simple")
    private Cliente cliente;
    @ElementCollection
    @ListProperties("servicio.numero, servicio.nombreServicio, cantidad, servicio.precio, impuesto.porcentaje")
    private Collection<DetalleFactura> detalleFacturas;
    @Money
    private BigDecimal subTotal;
    @Money
    private BigDecimal iva;
    @Money
    private BigDecimal total;
    @TextArea
    private String obervaciones;

}
