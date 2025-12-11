package org.example.AgenciaAduanera.modelo.Aduanero;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.example.AgenciaAduanera.modelo.Catalogos.Direccion;
import org.example.AgenciaAduanera.modelo.calculators.EstadoClienteDefaultCalculator;
import org.example.AgenciaAduanera.modelo.enums.EstadoCliente;
import org.openxava.annotations.DefaultValueCalculator;
import org.openxava.annotations.Required;
import org.openxava.annotations.View;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@View(name = "Simple",
members = "id, nombreCliente, ruc")

public class Cliente extends BaseEntity {

    @Required
    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Required
    private String ruc;

    @Required
    private String email;

    @Required
    private String telefono;

    @Embedded
    private Direccion direccion;

    @DefaultValueCalculator(EstadoClienteDefaultCalculator.class)
    @Enumerated(EnumType.STRING)
    private EstadoCliente estadoCliente;







}
