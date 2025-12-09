package com.saludintegral.Clinica.repositorio;

import com.saludintegral.Clinica.modelos.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepositorio extends JpaRepository<Cita, Long> {
    List<Cita> findByEstado(String estado);
}
