package org.example.AgenciaAduanera.modelo.seguridad;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.example.AgenciaAduanera.modelo.Catalogos.Sucursal;
//import org.example.AgenciaAduanera.modelo.SucursalEntity;
import org.example.AgenciaAduanera.modelo.enums.EstadoUsuario;
import org.example.AgenciaAduanera.modelo.util.Encriptar;
import org.openxava.annotations.*;

import javax.persistence.*;


@Entity
@Table(name = "usuario")
@Getter
@Setter

public class  Usuario extends BaseEntity {

    @Required
    private String username;
    @Required
    private String password;

    @Required
    private String nombre;

    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sucursal_id")
    @DescriptionsList(descriptionProperties = "nombre")
    private Sucursal sucursal;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id")
    @DescriptionsList(descriptionProperties = "nombre")
    private Rol rol;

    @Enumerated(EnumType.STRING)
    private EstadoUsuario estadoUsuario;

    public String getUsuario()  {
        return username;
    }

    public void setUsuario(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Encriptar.code(password);
    }



}
