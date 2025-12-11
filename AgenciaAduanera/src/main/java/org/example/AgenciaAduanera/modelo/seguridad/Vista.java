package org.example.AgenciaAduanera.modelo.seguridad;

import lombok.Getter;
import lombok.Setter;
import org.example.AgenciaAduanera.modelo.BaseEntity;
import org.openxava.annotations.Required;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "vista")
@Getter
@Setter
public class Vista extends BaseEntity {

    @Required
    private String nombreVista; // Debe coincidir con el nombre del m?dulo en OpenXava

    @ManyToMany(mappedBy = "vistas")
    private Set<Rol> roles = new HashSet<>();


}
