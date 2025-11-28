package org.example.orden.model;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tarifa")
@Getter
@Setter
@View(members =
        "servicio, moneda;" +
                "monto"
)
public class Tarifa extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @DescriptionsList(descriptionProperties = "nombre, descripcion")
    private Servicio servicio;

    @Money
    @Column(nullable = false)
    private BigDecimal monto;

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList(descriptionProperties = "nombreMoneda")
    private Moneda moneda;
}

