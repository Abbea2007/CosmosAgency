package org.example.AgenciaAduanera.modelo.Seguridad;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.example.AgenciaAduanera.modelo.Estado;
import org.example.AgenciaAduanera.modelo.Sucursal;
//import org.example.AgenciaAduanera.modelo.SucursalEntity;
import org.example.AgenciaAduanera.modelo.util.Encriptar;
import org.openxava.annotations.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;


@Entity
@Table(name = "usuario")
@Getter
@Setter

public class Usuario extends BaseEntity {

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
    @JoinColumn(name = "cargo_id")
    @DescriptionsList(descriptionProperties = "nombreCargo")
    private Cargo cargo;

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
