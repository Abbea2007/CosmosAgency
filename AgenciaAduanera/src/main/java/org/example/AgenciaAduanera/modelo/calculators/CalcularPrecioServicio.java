/*package org.example.AgenciaAduanera.modelo.calculators;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.Servicio;
import org.openxava.calculators.ICalculator;
import org.openxava.jpa.XPersistence;

import java.math.BigDecimal;

@Getter
@Setter

public class CalcularPrecioServicio implements ICalculator {

    private Long servicioId;

    @Override
    public Object calculate() throws Exception {
        if (servicioId == null) return BigDecimal.ZERO;

        Servicio s = XPersistence.getManager().find(Servicio.class, servicioId);

        return s != null && s.getPrecioServicio() != null
                ? s.getPrecioServicio()
                : BigDecimal.ZERO;
    }


}*/
