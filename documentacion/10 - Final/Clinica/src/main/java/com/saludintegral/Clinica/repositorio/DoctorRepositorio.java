package com.saludintegral.Clinica.repositorio;

import com.saludintegral.Clinica.modelos.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface DoctorRepositorio extends JpaRepository<Doctor, Integer> {

    @Query("SELECT d FROM Doctor d WHERE d.usuario.id_usuario = :idUsuario")
    Doctor findByUsuarioIdUsuario(@Param("idUsuario") int idUsuario);

    boolean existsByEmail(String email);
    boolean existsByTelefono(String telefono);
}