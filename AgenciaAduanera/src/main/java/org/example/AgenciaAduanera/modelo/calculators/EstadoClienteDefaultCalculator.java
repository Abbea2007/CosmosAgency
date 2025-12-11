package org.example.AgenciaAduanera.modelo.calculators;

import org.example.AgenciaAduanera.modelo.enums.EstadoCliente;
import org.openxava.calculators.ICalculator;

public class EstadoClienteDefaultCalculator implements ICalculator {
    @Override
    public Object calculate() throws Exception {
        return EstadoCliente.ACTIVO;
    }
}
