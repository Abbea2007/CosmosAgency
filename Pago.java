package org.example.orden.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name = "pago")
@Getter
@Setter
@View(members =
        "factura;" +
                "fecha, monto;" +
                "metodo, referencia"
)
public class Pago extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @DescriptionsList(descriptionProperties = "numero, total")
    private Factura factura;

    @Required
    private LocalDate fecha;

    @Money
    @Column(nullable = false)
    private BigDecimal monto;

    @Required
    @Column(length = 30)
    private String metodo;

    @Column(length = 50)
    private String referencia;
}

