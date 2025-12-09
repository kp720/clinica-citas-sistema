package com.saludintegral.Clinica.controlador;

import com.saludintegral.Clinica.modelos.*;
import com.saludintegral.Clinica.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class DoctorController {

    @Autowired
    private final ExpedienteService expedienteService;
    @Autowired
    private final DoctorService doctorService;
    @Autowired
    private final UsuarioService usuarioService;
    @Autowired
    private final CitaService citaService;
    @Autowired
    private final PacienteService pacienteService;
    @Autowired
    private LogActividadService logService;


    //Constructor
    public DoctorController(ExpedienteService expedienteService, DoctorService doctorService, UsuarioService usuarioService, CitaService citaService, PacienteService pacienteService, LogActividadService logService) {
        this.expedienteService = expedienteService;
        this.doctorService = doctorService;
        this.usuarioService = usuarioService;
        this.citaService = citaService;
        this.pacienteService = pacienteService;
        this.logService = logService;
    }

    //Redirección del login a la vista de Inicio de Doctor
    @GetMapping("/doctor/home")
    public String inicioDoctor(Model model, Principal principal) {

        String correo = principal.getName();
        Doctor doctor = doctorService.buscarPorCorreo(correo);

        if (doctor == null) {
            return "redirect:/login?error=notfound";
        }

        model.addAttribute("doctorNombre", doctor.getNombre());
        model.addAttribute("doctor", doctor);

        //Complementación de saludo dinámico
        String saludo = LocalTime.now().getHour() < 12 ? "¡Buenos días" :
                LocalTime.now().getHour() < 19 ? "¡Buenas tardes" :
                        "¡Buenas noches";

        model.addAttribute("saludo", saludo);

        return "doctor/doctor_inicio";
    }

    //Redirección para visualizacion del perfil de Doctor
    @GetMapping("/doctor/perfil")
    public String verPerfilDoctor(Model model, Principal principal) {
        String correo = principal.getName();
        Doctor doctor = doctorService.buscarPorCorreo(correo);

        if (doctor == null) {
            return "redirect:/login?error=notfound";
        }

        model.addAttribute("doctor", doctor);
        model.addAttribute("doctorNombre", doctor.getNombre());
        return "doctor/doctor_perfil";
    }

    //Redirección a la vista de citas de Doctor
    @GetMapping("/doctor/citas")
    public String verCitas(Model model, Authentication auth) {
        Doctor doctor = doctorService.buscarPorCorreo(auth.getName());
        List<Cita> citasPendientes = citaService.obtenerCitasPendientes();

        model.addAttribute("citas", citasPendientes);
        model.addAttribute("doctor", doctor);
        model.addAttribute("doctorNombre", doctor.getNombre());

        return "doctor/doctor_citas";
    }

    //Redirección al alta de una cita
    @GetMapping("/doctor/citas/{id}/finalizar")
    public String finalizarCita(@PathVariable("id") Integer idCita, Model model, Authentication auth) {

        Cita cita = citaService.buscarPorId(idCita);
        Doctor doctor = doctorService.buscarPorCorreo(auth.getName());

        if (cita == null) {
            return "redirect:/doctor/citas?error=citaNoEncontrada";
        }

        cita.setEstado("Alta");
        citaService.guardar(cita);

        model.addAttribute("cita", cita);
        model.addAttribute("paciente", cita.getPaciente());
        model.addAttribute("expediente", new Expediente());
        model.addAttribute("doctor", doctor);
        model.addAttribute("doctorNombre", doctor.getNombre());

        logService.registrar(
                ("Doctor(a): " + doctor.getNombre()),
                "ALTA_USUARIO",
                "Se dio de alta al paciente: " + cita.getPaciente().getNombre()
        );


        return "doctor/expediente_revision";
    }

    //Control de guardado de expediente
    @PostMapping("/doctor/expedientes/guardar")
    public String guardarExpediente(
            @RequestParam Integer idPaciente,
            @ModelAttribute Expediente expediente,
            Principal principal
    )
    {
        Paciente paciente = pacienteService.buscarPorId(idPaciente);
        expediente.setPaciente(paciente);
        expediente.setFecha(LocalDate.now());
        expediente.setEstadoExpediente("pendiente");


        String correo = principal.getName();
        Doctor doctor = doctorService.buscarPorCorreo(correo);

        expediente.setDoctor(doctor);

        expedienteService.guardar(expediente);

        logService.registrar(
                ("Doctor(a): " + doctor.getNombre()),
                "EXPEDIENTE_REVISION",
                "El expediente con ID " + expediente.getId_expediente() + " fue enviado a revisión"
        );

        return "redirect:/doctor/citas";
    }

    //Redirección a la lista de Expedientes de Doctor
    @GetMapping("/doctor/expedientes")
    public String listarExpedientes(Model model, Principal principal) {
        String correo = principal.getName();
        Doctor doctor = doctorService.buscarPorCorreo(correo);

        if (doctor == null) {
            return "redirect:/login?error=notfound";
        }

        model.addAttribute("doctor", doctor);

        model.addAttribute("doctorNombre", doctor.getNombre());

        List<Expediente> expedientes = expedienteService.listarExpedientes(doctor.getIdDoctor());

        if (expedientes.isEmpty()) {
            model.addAttribute("mensaje", "No tienes expedientes registrados aún.");
        }

        model.addAttribute("expedientes", expedientes);

        return "doctor/doctor_expedientes";
    }

    //Redirección de detalles de Expediente
    @GetMapping("/doctor/expedientes/{id}")
    public String verExpedienteCompleto(@PathVariable Integer id, Model model, Principal principal) {
        Expediente expediente = expedienteService.buscarPorId(id);

        String correo = principal.getName();
        Doctor doctor = doctorService.buscarPorCorreo(correo);

        model.addAttribute("doctorNombre", doctor.getNombre());
        model.addAttribute("expediente", expediente);
        model.addAttribute("doctor", doctor);
        return "doctor/expediente_detalles";
    }

    //Redirección a la vista de Pacientes de Doctores
    @GetMapping("/doctor/{id}/pacientes")
    public String verPacientesDelDoctor(@PathVariable Integer id, Model model) {
        Doctor doctor = doctorService.buscarPorId(id);
        List<Cita> citas = citaService.listarPorIdDoctor(id);
        Set<Paciente> pacientes = citas.stream()
                .map(Cita::getPaciente)
                .collect(Collectors.toSet());

        model.addAttribute("doctor", doctor);
        model.addAttribute("pacientes", pacientes);
        model.addAttribute("doctorNombre", doctor.getNombre());


        return "doctor/doctor_pacientes";
    }

    @GetMapping("/doctor/paciente/{id}")
    public String verExpedientesPaciente(@PathVariable Integer id, Model model, Principal principal) {

        String correo = principal.getName();
        Doctor doctor = doctorService.buscarPorCorreo(correo);

        Paciente paciente = pacienteService.buscarPorId(id);

        List<Expediente> expedientes = expedienteService.obtenerExpedientesPorPaciente(id);

        model.addAttribute("doctor", doctor);
        model.addAttribute("doctorNombre", doctor.getNombre());
        model.addAttribute("paciente", paciente);
        model.addAttribute("expedientes", expedientes);

        return "doctor/expedientes_paciente";
    }
}
