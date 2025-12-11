package org.example.AgenciaAduanera.modelo.calculators;

import org.example.AgenciaAduanera.modelo.enums.EstadoCliente;
import org.example.AgenciaAduanera.modelo.enums.EstadoUsuario;
import org.openxava.calculators.ICalculator;

public class EstadoUsuarioDefaultCalculator implements ICalculator {
    @Override
    public Object calculate() throws Exception {
        return EstadoUsuario.ACTIVO;
    }
}
