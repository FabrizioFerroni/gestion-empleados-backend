package com.gestion.empleados.gestionempleadosbackend.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fabrizio
 */
@RestController
public class HomeController {

    @GetMapping("/")
    public String srvCorriendo() {
        return "Si ves esto el server esta corriendo correctamente";
    }

    @GetMapping("/api")
    public String srvCorriendoApi() {
        return "Si ves esto el server esta corriendo correctamente, y devuelve el api";
    }
}
