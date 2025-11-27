package org.example.AgenciaAduanera.modelo.Aduanero;

import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.example.AgenciaAduanera.modelo.Catalogos.EstadoDeclaracion;
import org.example.AgenciaAduanera.modelo.calculators.CalcularNumero;
import org.openxava.annotations.DefaultValueCalculator;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.PropertyValue;
import org.openxava.annotations.Required;
import org.openxava.calculators.CurrentYearCalculator;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;

public class Declaracion extends BaseEntity {


    @DefaultValueCalculator(value = CalcularNumero.class, properties = @PropertyValue(name = "anio"))
    private String numeroDeclaracion;
    @DefaultValueCalculator(CurrentYearCalculator.class)
    private LocalDate fechaDeclaracion;
    @Required
    private String tipoDeclaracion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Expediente expediente;


}
