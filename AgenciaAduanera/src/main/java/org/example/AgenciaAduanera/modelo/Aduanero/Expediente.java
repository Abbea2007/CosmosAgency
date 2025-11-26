package org.example.AgenciaAduanera.modelo.Aduanero;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.example.AgenciaAduanera.modelo.Catalogos.EstadoExpediente;
import org.example.AgenciaAduanera.modelo.Cliente;
import org.example.AgenciaAduanera.modelo.Estado;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.Required;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "expediente")
@Getter
@Setter
public class Expediente extends BaseEntity {

    @Required
    private String codigoExpediente;
    @Required
    private Long anio;
    @Required
    private LocalDate fecha_apertura;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    @DescriptionsList(descriptionProperties="nombreCliente")
    private Cliente cliente;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_expediente_id")
    @DescriptionsList(descriptionProperties="nombreEstado")
    private EstadoExpediente estadoExpediente;

}
