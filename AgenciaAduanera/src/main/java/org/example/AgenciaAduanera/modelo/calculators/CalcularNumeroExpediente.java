package org.example.AgenciaAduanera.modelo.calculators;

import lombok.Getter;
import lombok.Setter;
import org.openxava.calculators.ICalculator;
import org.openxava.jpa.XPersistence;

import javax.persistence.Query;

public class CalcularNumeroExpediente implements ICalculator {

    @Getter
    @Setter
    private int anio;

    public Object calculate() throws Exception {
        Query query = XPersistence.getManager()
                .createQuery("SELECT MAX(e.codigoExpediente) FROM Expediente e  WHERE e.anio = :anyo");
        query.setParameter("anyo", anio);
        Integer ultimoNumero = (Integer) query.getSingleResult();
        return ultimoNumero == null ? 1 : ultimoNumero + 1;
    }
}
