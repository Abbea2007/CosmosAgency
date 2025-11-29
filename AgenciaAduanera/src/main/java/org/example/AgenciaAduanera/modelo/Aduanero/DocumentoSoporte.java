package org.example.AgenciaAduanera.modelo.Aduanero;


import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentYearCalculator;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Getter
@Setter

@View(members =
        "numeroDocumento;" +
        "fecha;" +
        "archivo; " +
        "url;" +
        "descripcion;")


public class DocumentoSoporte  extends BaseEntity {

    @Required

    private String numeroDocumento;

    @DefaultValueCalculator(CurrentYearCalculator.class)
    private LocalDate fecha;

    @File
    private byte[] archivo;

    private String url;

    private String descripcion;


    @ManyToOne(fetch = javax.persistence.FetchType.LAZY, optional = false)
    @JoinColumn(name = "declaracion_id")
    private Declaracion declaracion;
}
