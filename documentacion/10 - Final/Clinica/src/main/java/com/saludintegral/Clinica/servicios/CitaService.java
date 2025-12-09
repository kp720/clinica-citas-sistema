package com.saludintegral.Clinica.servicios;


import com.saludintegral.Clinica.modelos.Cita;
import com.saludintegral.Clinica.modelos.Doctor;
import com.saludintegral.Clinica.modelos.Paciente;
import com.saludintegral.Clinica.repositorio.CitaRepositorio;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CitaService {

    @Autowired
    private final CitaRepositorio citaRepositorio;
    @Autowired
    private final ServicioCorreos servicioCorreos;

    public CitaService(CitaRepositorio citaRepositorio, ServicioCorreos servicioCorreos) {
        this.citaRepositorio = citaRepositorio;
        this.servicioCorreos = servicioCorreos;
    }
    public List<Cita> obtenerCitasPendientes() {
        return citaRepositorio.findByEstado("pendiente");
    }
    public List<Cita> listarTodas() {
        return citaRepositorio.findAll();
    }
    public Cita buscarPorId (int IdCita){
        return citaRepositorio.findById(IdCita).orElse(null);
    }

    public List<Cita> listarPorIdDoctor(int IdDoctor){
        return citaRepositorio.findByDoctorIdDoctor(IdDoctor);
    }

    public void guardar(Cita cita) {
        citaRepositorio.save(cita);
    }
    public void eliminar(int id) {
        citaRepositorio.deleteById(id);
    }

    public List<Paciente> listarPacientesDeDoctor(Integer idDoctor) {
        List<Cita> citas = citaRepositorio.findByDoctorIdDoctor(idDoctor);

        return citas.stream()
                .map(Cita::getPaciente)
                .distinct()
                .collect(Collectors.toList());
    }

    public void validarFechaNoPasada(LocalDate fecha) {
        if (fecha.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("No puedes agendar citas en fechas pasadas.");
        }
    }

    public void validarFechaHoraNoPasada(LocalDate fecha, LocalTime hora) {
        if (fecha.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha ya pasó.");
        }

        if (fecha.isEqual(LocalDate.now()) && hora.isBefore(LocalTime.now())) {
            throw new IllegalArgumentException("La hora ya pasó.");
        }
    }


    public void validarDisponibilidadDoctor(Doctor doctor, LocalDate fecha, LocalTime hora) {
        List<Cita> citas = citaRepositorio
                .findByDoctorIdDoctorAndFechaAndHora(doctor.getIdDoctor(), fecha, hora);

        if (!citas.isEmpty()) {
            throw new IllegalArgumentException("El doctor ya tiene una cita en esa fecha y hora.");
        }
    }

    public Cita guardarCita(Cita cita) throws MessagingException {

        validarFechaHoraNoPasada(cita.getFecha(), cita.getHora());
        validarDisponibilidadDoctor(cita.getDoctor(), cita.getFecha(), cita.getHora());

        Cita guardada = citaRepositorio.save(cita);
        servicioCorreos.enviarCorreo(guardada);
        return guardada;

    }

}

