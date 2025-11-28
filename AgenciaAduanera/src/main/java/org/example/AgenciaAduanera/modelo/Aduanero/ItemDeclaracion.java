package org.example.AgenciaAduanera.modelo.Aduanero;


import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.example.AgenciaAduanera.modelo.Catalogos.CodigoArancelario;
import org.example.AgenciaAduanera.modelo.Catalogos.Pais;
import org.example.AgenciaAduanera.modelo.Catalogos.UnidadMedida;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.Money;
import org.openxava.annotations.Required;
import org.openxava.annotations.View;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@View(members =
        "descripcionItem;" +
        "cantidad;" +
        "pesoUnitario;" +
        "valor;" +
        "pais;" +
        "codigoArancelario;" +
        "unidadMedida;" +
        "declaracion"
)

public class ItemDeclaracion extends BaseEntity {

    private String descripcionItem;
    @Required
    private Integer cantidad;
    @Required
    private Double pesoUnitario;
    @Required
    @Money
    private Double valor;

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
