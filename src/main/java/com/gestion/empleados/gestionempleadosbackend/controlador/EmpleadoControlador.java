package com.gestion.empleados.gestionempleadosbackend.controlador;

import com.gestion.empleados.gestionempleadosbackend.excepciones.ResourceNotFoundException;
import com.gestion.empleados.gestionempleadosbackend.repositorio.EmpleadoRepositorio;
import com.gestion.empleados.gestionempleadosbackend.modelo.Empleado;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fabrizio
 */
@RestController
@RequestMapping("/api/")
@CrossOrigin("https://ang-employee-manager.netlify.app/")
public class EmpleadoControlador {

    @Autowired
    private EmpleadoRepositorio repositorio;

    // Este metodo sirve para listar todos los empleados
    @GetMapping("empleados")
    public List<Empleado> listarTodosLosEmpleados() {
        return repositorio.findAll();
    }
    
    //Prueba agregar datos falsos a BD
    @RequestMapping("agregar-empleados")
    public String save(){
        Empleado empleado = new Empleado();
        empleado.setNombre("Prueba");
        empleado.setApellido("Spring Boot");
        empleado.setEmail("test-spring@ejemplo.com");

        repositorio.save(empleado);//guardar datos.
        //return "ok.DemoController.save";
        return "Empleado creado con exito";
    }
    
    
    // Este metodo sirve para agregar empleados
    @PostMapping("empleados")
    public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
        return repositorio.save(empleado);
    }

    // Este metodo sirve para encontrar un empleado por id
    @GetMapping("empleado/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable Long id) {
        Empleado empleado = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("No existe el empleado con el id: " + id)));

        return ResponseEntity.ok(empleado);
    }

    // Este metodo sirve para encontrar un empleado por id y editar
    @PutMapping("empleado/{id}/editar")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado detallesEmpleado) {
        Empleado empleado = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("No existe el empleado con el id: " + id)));

        empleado.setNombre(detallesEmpleado.getNombre());
        empleado.setApellido(detallesEmpleado.getApellido());
        empleado.setEmail(detallesEmpleado.getEmail());

        Empleado empleadoActualizado = repositorio.save(empleado);
        return ResponseEntity.ok(empleadoActualizado);
    }

    @DeleteMapping("empleado/{id}/eliminar")
    public ResponseEntity<Map<String, Boolean>> eliminarEmpleado(@PathVariable Long id) {
        Empleado empleado = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(("No existe el empleado con el id: " + id)));

        repositorio.delete(empleado);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
