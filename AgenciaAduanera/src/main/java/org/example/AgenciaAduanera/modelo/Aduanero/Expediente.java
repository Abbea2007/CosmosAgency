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
import java.util.Collection;


@Entity
@Table(name = "expediente")
@Getter
@Setter
@Views({
        @View(name = "Simple", members =
                "codigoExpediente, anio, fecha_apertura;" +
                "cliente;"),


        @View(members =
        "codigoExpediente, anio, fecha_apertura;" +
        "cliente;" +
        "estadoExpediente;")
})

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
    @ReferenceView("Simple")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "estado_expediente_id")
    private EstadoExpediente estadoExpediente;

    @OneToMany(mappedBy = "expediente", fetch = FetchType.LAZY)
    private Collection<Declaracion> declaraciones;


}
