package org.example.AgenciaAduanera.modelo.transacciones;


import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.openxava.annotations.Money;
import org.openxava.annotations.TextArea;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Servicio extends BaseEntity {


    private String numero;
    private String nombreServicio;
    @Money
    private BigDecimal precioServicio;
    @TextArea
    private String obervaciones;

}
