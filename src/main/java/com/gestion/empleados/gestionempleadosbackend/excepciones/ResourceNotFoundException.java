package com.gestion.empleados.gestionempleadosbackend.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Fabrizio
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionID = 1L;

    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}
