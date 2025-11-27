package org.example.AgenciaAduanera.modelo.Aduanero;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.example.AgenciaAduanera.modelo.Catalogos.EstadoExpediente;
import org.example.AgenciaAduanera.modelo.Cliente;
import org.example.AgenciaAduanera.modelo.Estado;
import org.example.AgenciaAduanera.modelo.calculators.CalcularNumero;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentDateCalculator;
import org.openxava.calculators.CurrentYearCalculator;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "expediente")
@Getter
@Setter
@View(members =
        "codigoExpediente, anio, fecha_apertura;" +
        "cliente;" +
        "estadoExpediente;")

public class Expediente extends BaseEntity {

    @Required
    @DefaultValueCalculator(value = CalcularNumero.class, properties = @PropertyValue(name = "anio"))
    private int codigoExpediente;
    @Required
    @DefaultValueCalculator(CurrentYearCalculator.class)
    private int anio;
    @Required
    @DefaultValueCalculator(CurrentYearCalculator.class)
    private LocalDate fecha_apertura;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_expediente_id")
    @DescriptionsList(descriptionProperties="nombreEstado")
    private EstadoExpediente estadoExpediente;

}
