package org.example.AgenciaAduanera.modelo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.Hidden;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter

public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Long id;


}
