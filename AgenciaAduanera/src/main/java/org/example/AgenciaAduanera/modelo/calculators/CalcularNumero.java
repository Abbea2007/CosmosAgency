package org.example.AgenciaAduanera.modelo.calculators;


import lombok.Getter;
import lombok.Setter;
import org.openxava.calculators.ICalculator;
import org.openxava.jpa.XPersistence;

import javax.persistence.Query;

public class CalcularNumero implements ICalculator {

    @Getter
    @Setter
    private int anyo;

    public Object calculate() throws Exception {
        Query query = XPersistence.getManager()
                .createQuery("SELECT MAX(f.numero) FROM Factura f  WHERE f.anyo = :anyo");
        query.setParameter("anyo", anyo);
        Integer ultimoNumero = (Integer) query.getSingleResult();
        return ultimoNumero == null ? 1 : ultimoNumero + 1;
    }





}
