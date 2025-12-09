package com.saludintegral.Clinica.servicios;

import com.saludintegral.Clinica.modelos.Cita;
import com.saludintegral.Clinica.modelos.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.saludintegral.Clinica.repositorio.ExpedienteRepositorio;
import com.saludintegral.Clinica.modelos.Expediente;


@Service
public class ExpedienteService {

    @Autowired
    private final ExpedienteRepositorio expedienteRepositorio;
    @Autowired
    private final ServicioCorreos servicioCorreos;

    public ExpedienteService(ExpedienteRepositorio expedienteRepositorio, ServicioCorreos servicioCorreos) {
        this.expedienteRepositorio = expedienteRepositorio;
        this.servicioCorreos = servicioCorreos;
    }

    public List<Expediente> obtenerExpedientesPendientes() {
        return expedienteRepositorio.findByEstadoExpediente("pendiente");
    }

    public List<Expediente> listarExpedientes(int IdDoctor) {
        return expedienteRepositorio.findByDoctor_IdDoctor(IdDoctor);
    }

    public List<Expediente> listarTodos() {
        return expedienteRepositorio.findAll();
    }

    public List<Paciente> obtenerPacientesAtendidos(int idDoctor) {
        return expedienteRepositorio.obtenerPacientesAtendidos(idDoctor);
    }

    public Expediente buscarPorId(int IdExpediente){
        return expedienteRepositorio.findById(IdExpediente).orElse(null);
    }

    public List<Expediente> obtenerExpedientesPorPaciente(Integer idPaciente) {
        return expedienteRepositorio.findByPaciente_Id(idPaciente);
    }

    public void guardar(Expediente expediente){
        servicioCorreos.enviarCorreo2(expediente);
        expedienteRepositorio.save(expediente);
    }
    public void eliminar(int IdExpediente){
        expedienteRepositorio.deleteById(IdExpediente);
    }

}