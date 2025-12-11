package org.example.AgenciaAduanera.modelo.auditoria;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
public class Auditoria {

        private String usuarioIng;
        private String usuarioAct;
        private LocalDateTime fechaIng;
        private LocalDateTime fechaAct;
    }

