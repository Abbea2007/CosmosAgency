package org.example.AgenciaAduanera.modelo.Aduanero;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.example.AgenciaAduanera.modelo.Catalogos.*;
import org.example.AgenciaAduanera.modelo.calculators.CalcularNumero;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentYearCalculator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;


@Entity
@Getter
@Setter
@View(members =
        "numeroDeclaracion, fechaDeclaracion, tipoDeclaracion, estadoDeclaracion;" +
        "expediente;" +
        "tranportista;" +
        "consignatario;" +
        "remitente;" +
        "medioTransporte;" +
"items;" +
"documentoSoportes;" +
"contenedores;")

public class Declaracion extends BaseEntity {


    @DefaultValueCalculator(value = CalcularNumero.class, properties = @PropertyValue(name = "anio"))
    private String numeroDeclaracion;
    @DefaultValueCalculator(CurrentYearCalculator.class)
    private LocalDate fechaDeclaracion;
    @Required
    private String tipoDeclaracion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name= "estado_declaracion_id")
    @DescriptionsList(descriptionProperties="nombre")
    private EstadoDeclaracion estadoDeclaracion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name= "expediente_id")
    @ReferenceView("Simple")
    private Expediente expediente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name= "tranportista_id")
    @DescriptionsList(descriptionProperties="nombre")
    private  Tranportista tranportista;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name= "consignatario_id")
    @DescriptionsList(descriptionProperties="nombre")
    private Consignatario consignatario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name= "remitente_id")
    @DescriptionsList(descriptionProperties="nombre")
    private Remitente remitente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "medio_transporte_id")
    @DescriptionsList(descriptionProperties="nombre")
    private MedioTransporte medioTransporte;

    @OneToMany(mappedBy = "declaracion", fetch = FetchType.LAZY)
    @ListProperties("descripcionItem, cantidad, pesoUnitario, valor, unidadMedida.abreviatura, pais.nombrepais, codigoArancelario.codigo")
    private Collection<ItemDeclaracion> items;

    @OneToMany(mappedBy = "declaracion", fetch = FetchType.LAZY)
    @ListProperties("numeroDocumento, fecha, url, descripcion")
    private Collection<DocumentoSoporte> documentoSoportes;

    @OneToMany(mappedBy = "declaracion", fetch = FetchType.LAZY)
    @ListProperties("codigo, tipo, capacidad")
    private Collection<Contenedor>contenedores;
}
