package org.example.AgenciaAduanera.modelo.Aduanero;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.example.AgenciaAduanera.modelo.Catalogos.EstadoDeclaracion;
import org.example.AgenciaAduanera.modelo.Catalogos.Tranportista;
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
        "numeroDeclaracion, fechaDeclaracion, tipoDeclaracion;" +
        "expediente;" +
        "tranportista;" +
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
    @JoinColumn(name= "expediente_id")
    private Expediente expediente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name= "tranportista_id")
    @DescriptionsList(descriptionProperties="nombre")
    private  Tranportista tranportista;

    @OneToMany(mappedBy = "declaracion", fetch = FetchType.LAZY)
    @ListProperties("descripcionItem, cantidad, pesoUnitario, valor, unidadMedida.abreviatura, pais.nombrepais, codigoArancelario.codigo")
    private Collection<ItemDeclaracion> items;

    @OneToMany(mappedBy = "declaracion", fetch = FetchType.LAZY)
    @ListProperties("numeroDocumento, fecha, archivo, url, descripcion")
    private Collection<DocumentoSoporte> documentoSoportes;

    @OneToMany(mappedBy = "declaracion", fetch = FetchType.LAZY)
    @ListProperties("codigo, tipo, capacidad")
    private Collection<Contenedor>contenedores;
}
