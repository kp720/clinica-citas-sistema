package com.saludintegral.Clinica.repositorio;

import com.saludintegral.Clinica.modelos.Expediente;
import com.saludintegral.Clinica.modelos.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpedienteRepositorio extends JpaRepository<Expediente, Integer> {
    List<Expediente> findByDoctor_IdDoctor(int idDoctor);

    @Query("SELECT DISTINCT e.paciente FROM Expediente e WHERE e.doctor.idDoctor = :idDoctor")
    List<Paciente> obtenerPacientesAtendidos(@Param("idDoctor") int idDoctor);

    List<Expediente> findByPaciente_Id(Integer idPaciente);

    List<Expediente> findByEstadoExpediente(String estado);

}

