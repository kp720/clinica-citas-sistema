package com.saludintegral.Clinica.repositorio;

import com.saludintegral.Clinica.modelos.Expediente;
import com.saludintegral.Clinica.modelos.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepositorio extends JpaRepository<Paciente, Integer> {
    boolean existsByEmail(String email);
    boolean existsByTelefono(String telefono);
}
