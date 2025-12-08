package org.example.AgenciaAduanera.modelo.Aduanero;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.example.AgenciaAduanera.modelo.Catalogos.EstadoExpediente;
import org.example.AgenciaAduanera.modelo.Cliente;
//import org.example.AgenciaAduanera.modelo.SucursalEntity;
import org.example.AgenciaAduanera.modelo.FilterRestrictiva;
import org.example.AgenciaAduanera.modelo.Sucursal;
import org.example.AgenciaAduanera.modelo.calculators.CalcularNumero;
import org.example.AgenciaAduanera.modelo.calculators.CalcularNumeroExpediente;
import org.hibernate.annotations.Filter;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentYearCalculator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;



@FilterRestrictiva
@Entity
@Table(name = "expediente")
@Getter
@Setter
@Views({
        @View(name = "Simple", members =
                "codigoExpediente, anio, fecha_apertura, fecha_cierre;" +
                "cliente;"),


        @View(members =
        "codigoExpediente, anio, fecha_apertura, fecha_cierre;" +
        "cliente;" +
        "estadoExpediente;" +
        "sucursal;")
})

public class Expediente extends BaseEntity {



    @Required
    @DefaultValueCalculator(value = CalcularNumeroExpediente.class, properties = @PropertyValue(name = "anio"))
    private int codigoExpediente;
    @Required
    @DefaultValueCalculator(CurrentYearCalculator.class)
    private int anio;
    @Required
    @DefaultValueCalculator(CurrentYearCalculator.class)
    private LocalDate fecha_apertura;

    private LocalDate fecha_cierre;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ReferenceView("Simple")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "estado_expediente_id")
    private EstadoExpediente estadoExpediente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sucursal_id")
    @DescriptionsList(descriptionProperties = "nombre")
    private Sucursal sucursal;

    @OneToMany(mappedBy = "expediente", fetch = FetchType.LAZY)
    private Collection<Declaracion> declaraciones;



}
