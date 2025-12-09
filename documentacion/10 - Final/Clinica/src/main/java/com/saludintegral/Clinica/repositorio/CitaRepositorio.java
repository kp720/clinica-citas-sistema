package com.saludintegral.Clinica.repositorio;

import com.saludintegral.Clinica.modelos.Cita;
import com.saludintegral.Clinica.modelos.Encargado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface CitaRepositorio extends JpaRepository<Cita, Integer> {
    List<Cita> findByEstado(String estado);

    List<Cita> findByDoctorIdDoctor(Integer idDoctor);

    List<Cita> findByEncargado(Encargado encargado);

    List<Cita> findByFechaAndHora(LocalDate fecha, LocalTime hora);

    List<Cita> findByDoctorIdDoctorAndFechaAndHora(Integer idDoctor, LocalDate fecha, LocalTime hora);
}
