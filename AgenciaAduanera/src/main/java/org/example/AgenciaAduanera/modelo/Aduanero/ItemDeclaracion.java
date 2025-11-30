package org.example.AgenciaAduanera.modelo.Aduanero;


import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.example.AgenciaAduanera.modelo.Catalogos.CodigoArancelario;
import org.example.AgenciaAduanera.modelo.Catalogos.Pais;
import org.example.AgenciaAduanera.modelo.Catalogos.UnidadMedida;
import org.openxava.annotations.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@View(members =
        "descripcionItem;" +
        "cantidad;" +
        "valorUnitario;" +
        "importe;" +
        "flete;" +
        "seguro;" +
        "otrosGastos;" +
        "baseImponible;" +
        "pais;" +
        "codigoArancelario;" +
        "unidadMedida;")

public class ItemDeclaracion extends BaseEntity {

    private String descripcionItem;
    @Required
    private Integer cantidad;
    @Required
    @Money
    private Double valorUnitario;
    @Calculation("cantidad * valorUnitario")
    @Money
    private Double importe;
    @Money
    private Double flete;
    @Money
    private Double seguro;
    @Money
    private Double otrosGastos;
    @Calculation("importe + flete + seguro + otrosGastos")
    @Money
    private BigDecimal baseImponible;

    @ManyToOne(fetch = javax.persistence.FetchType.LAZY, optional = false)
    private Pais pais;

    @ManyToOne(fetch = javax.persistence.FetchType.LAZY, optional = false)
    private CodigoArancelario codigoArancelario;

    @ManyToOne(fetch = javax.persistence.FetchType.LAZY, optional = false)
    private UnidadMedida unidadMedida;


    @ManyToOne(fetch = javax.persistence.FetchType.LAZY, optional = false)
    @JoinColumn(name = "declaracion_id")
    private Declaracion declaracion;


    }




