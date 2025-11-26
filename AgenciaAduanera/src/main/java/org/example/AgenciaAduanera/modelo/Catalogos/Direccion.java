package org.example.AgenciaAduanera.modelo.Catalogos;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter

public class Direccion {

    private String calle;
    private String codigoPostal;
    private String departamento;
    private String municipio;

}
