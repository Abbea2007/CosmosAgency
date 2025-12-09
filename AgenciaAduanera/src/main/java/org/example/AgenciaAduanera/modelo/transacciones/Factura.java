package org.example.AgenciaAduanera.modelo.transacciones;


import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.Aduanero.Cliente;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.example.AgenciaAduanera.modelo.calculators.CalcularNumero;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentYearCalculator;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
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
        "porcentajeIva; " +
                "iva;  "+
        "importeTotal; " +
        "obervaciones")
        })

public class Factura extends BaseEntity {


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
    @ListProperties("servicio.numero, servicio.nombreServicio, servicio.precioServicio")
    private Collection<DetalleFactura> detalleFacturas;

    @Digits(integer=12, fraction=0)
    private BigDecimal porcentajeIva;

    @ReadOnly
    @Money
    @Calculation("sum(detalleFacturas.servicio.precioServicio) * porcentajeIva / 100")
    private BigDecimal iva;

    @ReadOnly
    @Money
    @Calculation("sum(detalleFacturas.servicio.precioServicio) + iva")
    private BigDecimal importeTotal;



    @TextArea
    private String obervaciones;

}
