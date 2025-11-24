package org.example.AgenciaAduanera.modelo;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.Required;
import org.openxava.annotations.View;
import org.openxava.annotations.Views;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@Views({
        @View(name = "Simple", members =
                "nombreCliente;" +
                        "ruc;" +
                        "email;" +
                        "telefono;" +
                        "direccion;" +
                        "municipio;" +
                        "estado;"),
        @View(name = "init", members =
                "nombreCliente;" +
                        "ruc;" +
                        "email;" +
                        "telefono;" +
                        "direccion;" +
                        "municipio;" +
                        "estado;"),
        @View(members =
                "nombreCliente;" +
                        "ruc;" +
                        "email;" +
                        "telefono;" +
                        "direccion;" +
                        "municipio;" +
                        "estado;")
})
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

    @Required
    private String direccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "municipio_id")
    @DescriptionsList(descriptionProperties = "nombreMunicipio")
    private Municipio municipio;

    @Required
    @Enumerated(EnumType.STRING)
    private Estado estado;
}
