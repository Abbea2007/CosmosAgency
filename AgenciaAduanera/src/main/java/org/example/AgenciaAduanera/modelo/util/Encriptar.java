package org.example.AgenciaAduanera.modelo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Encriptar {

    public static String code(String value) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(value);

    }
}
