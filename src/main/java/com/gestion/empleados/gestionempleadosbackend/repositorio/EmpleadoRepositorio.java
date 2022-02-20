package com.gestion.empleados.gestionempleadosbackend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gestion.empleados.gestionempleadosbackend.modelo.Empleado;

/**
 *
 * @author Fabrizio
 */

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {
    
}
