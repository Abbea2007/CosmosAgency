package org.example.AgenciaAduanera.modelo;


import lombok.Getter;
import lombok.Setter;
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
