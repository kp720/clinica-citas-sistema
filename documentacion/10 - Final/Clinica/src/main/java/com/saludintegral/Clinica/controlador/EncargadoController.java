package com.saludintegral.Clinica.controlador;

import com.saludintegral.Clinica.dto.DoctorDTO;
import com.saludintegral.Clinica.modelos.*;
import com.saludintegral.Clinica.servicios.*;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
public class EncargadoController {

    
    private final EncargadoService encargadoService;
    private final PacienteService pacienteService;
    private final DoctorService doctorService;
    private final CitaService citaService;
    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;
    private final ExpedienteService expedienteService;
    private final LogActividadService logActividadService;

    @Autowired
    public EncargadoController (EncargadoService encargadoService, PacienteService pacienteService, DoctorService doctorService, CitaService citaService, ExpedienteService expedienteService, UsuarioService usuarioService, PasswordEncoder passwordEncoder, LogActividadService logActividadService){
        this.encargadoService = encargadoService;
        this.pacienteService = pacienteService;
        this.doctorService = doctorService;
        this.citaService = citaService;
        this.expedienteService = expedienteService;
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
        this.logActividadService = logActividadService;
    }

    //Redirección a la vista de Inicio de Encargado
    @GetMapping("/encargado/home")
    public String homeEncargado(Model model, Authentication auth) {

        String correo = auth.getName();
        Encargado encargado = encargadoService.buscarPorUsuario(correo);

        if (encargado == null) {
            return "redirect:/login?error=notfound";
        }

        model.addAttribute("encargadoNombre", encargado.getNombre());
        model.addAttribute("encargado", encargado);

        //Complementación de saludo dinámico
        String saludo = LocalTime.now().getHour() < 12 ? "¡Buenos días" :
                LocalTime.now().getHour() < 19 ? "¡Buenas tardes" :
                        "¡Buenas noches";

        model.addAttribute("saludo", saludo);

        return "encargado/encargado_inicio";
    }


    //Redirección para visualizacion del perfil del Encargado
    @GetMapping("/encargado/perfil")
    public String verPerfilDoctor(Model model, Principal principal) {
        String correo = principal.getName();
        Encargado encargado = encargadoService.buscarPorCorreo(correo);

        if (encargado == null) {
            return "redirect:/login?error=notfound";
        }

        model.addAttribute("encargado", encargado);
        model.addAttribute("encargadoNombre", encargado.getNombre());
        return "encargado/encargado_perfil";
    }

    //Redirección a la vista de citas de Encargado
    @GetMapping("/encargado/citas")
    public String verCitas(Model model, Authentication auth) {
        Encargado encargado = encargadoService.buscarPorCorreo(auth.getName());

        model.addAttribute("encargado", encargado);
        List<Cita> citas = encargadoService.buscarPorEncargado(encargado);

        model.addAttribute("citas", citas);
        model.addAttribute("encargado", encargado);
        model.addAttribute("encargadoNombre", encargado.getNombre());

        return "encargado/encargado_citas";
    }

    //Redirección al formulario de Nueva cita
    @GetMapping("/encargado/cita/nueva")
    public String nuevaCita(Model model, Authentication auth) {

        String correo = auth.getName();
        Encargado encargado = encargadoService.buscarPorUsuario(correo);

        Cita cita = new Cita();
        cita.setEncargado(encargado);

        model.addAttribute("cita", cita);
        model.addAttribute("encargado", encargado);
        model.addAttribute("encargadoNombre", encargado.getNombre());
        model.addAttribute("pacientes", pacienteService.listarPacientes());

        return "modCitas/cita_nueva";
    }

    //Envio de Doctores disponibles al formulario de citas nueva y modificación de citas
    @GetMapping("/encargado/doctores/disponibles")
    @ResponseBody
    public List<DoctorDTO> obtenerDisponibles(
            @RequestParam LocalDate fecha,
            @RequestParam LocalTime hora
    ) {
        return doctorService.buscarDoctoresDisponibles(fecha, hora);
    }

    //Guardo y validación de excepciones al crear cita
    @PostMapping("/encargado/cita/guardar")
    public String guardar(@ModelAttribute Cita cita,
                          @RequestParam("doctorId") Integer doctorId,
                          @RequestParam("pacienteId") Integer pacienteId,
                          Authentication auth,
                          RedirectAttributes redirect) {

        String correo = auth.getName();
        Encargado encargado = encargadoService.buscarPorUsuario(correo);
        cita.setEncargado(encargado);

        Doctor doctor = doctorService.buscarPorId(doctorId);
        cita.setDoctor(doctor);

        Paciente paciente = pacienteService.buscarPorId(pacienteId);
        cita.setPaciente(paciente);

        cita.setEstado("pendiente");

        try {
            citaService.guardarCita(cita);

            logActividadService.registrar(
                    ("Encargado(a): "+ encargado.getNombre()),
                    "AGREGAR_CITA",
                    "Se agregó una nueva cita con ID = " + cita.getId()
            );

            redirect.addFlashAttribute("mensaje", "Cita registrada correctamente.");
            return "redirect:/encargado/citas";

        } catch (IllegalArgumentException e) {
            redirect.addFlashAttribute("error", e.getMessage());
            return "redirect:/encargado/cita/nueva";
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    //Eliminación de cita y recarga de la página
    @GetMapping("/encargado/citas/eliminar/{id}")
    public String eliminar(@PathVariable Integer id, RedirectAttributes redirect) {

        try {
            citaService.eliminar(id);
            redirect.addFlashAttribute("mensaje", "Cita eliminada correctamente.");
        } catch (IllegalArgumentException e) {
            redirect.addFlashAttribute("error", e.getMessage());
        }

        return "redirect:/encargado/citas";
    }

    //Redirección a la lista de Expedientes de Encargado
    @GetMapping("/encargado/expedientes")
    public String listarExpedientes(Model model, Principal principal) {
        String correo = principal.getName();
        Encargado encargado = encargadoService.buscarPorCorreo(correo);

        if (encargado == null) {
            return "redirect:/login?error=notfound";
        }

        model.addAttribute("encargado", encargado);
        model.addAttribute("encargadoNombre", encargado.getNombre());

        List<Expediente> expedientes = expedienteService.obtenerExpedientesPendientes();

        if (expedientes.isEmpty()) {
            model.addAttribute("mensaje", "No tienes expedientes registrados aún.");
        }

        model.addAttribute("expedientes", expedientes);

        return "encargado/encargado_expedientes";
    }

    //Redirección de detalles de Expediente
    @GetMapping("/encargado/expedientes/{id}")
    public String verExpedienteCompleto(@PathVariable Integer id, Model model, Principal principal) {
        Expediente expediente = expedienteService.buscarPorId(id);

        String correo = principal.getName();
        Encargado encargado = encargadoService.buscarPorCorreo(correo);

        model.addAttribute("encargadoNombre", encargado.getNombre());
        model.addAttribute("expediente", expediente);
        model.addAttribute("encargado", encargado);
        return "encargado/expediente_detalles_en";
    }

    //Redirección para aprobar expedientes
    @GetMapping("/encargado/expedientes/aprobar/{id}")
    public String aprobarExpediente(@PathVariable Integer id, Model model, Principal principal){
        Expediente expediente = expedienteService.buscarPorId(id);

        String correo = principal.getName();
        Encargado encargado = encargadoService.buscarPorCorreo(correo);

        model.addAttribute("encargadoNombre", encargado.getNombre());
        model.addAttribute("expediente", expediente);
        model.addAttribute("encargado", encargado);

        return "encargado/aprobar_expediente";
    }

    //Guardado y aprobación de expediente
    @PostMapping("/encargado/expediente/aprobar/guardar")
    public String guardarAprobacion(
            @ModelAttribute("expediente") Expediente expedienteForm,
            Authentication auth,
            RedirectAttributes redirect) {

        Expediente expediente = expedienteService.buscarPorId(expedienteForm.getId_expediente());

        String correo = auth.getName();
        Encargado encargado = encargadoService.buscarPorUsuario(correo);

        expediente.setDiagnosticos(expedienteForm.getDiagnosticos());
        expediente.setObservaciones(expedienteForm.getObservaciones());
        expediente.setRecetas(expedienteForm.getRecetas());
        expediente.setTratamientos(expedienteForm.getTratamientos());

        expediente.setEstadoExpediente("Aprobado");

        expedienteService.guardar(expediente);

        logActividadService.registrar(
                ("Encargado: "+encargado.getNombre()),
                "EXPEDIENTE_APROBADO",
                "Se aprobó el expediente con ID " + expediente.getId_expediente()
        );


        redirect.addFlashAttribute("mensaje", "Expediente aprobado correctamente.");
        return "redirect:/encargado/expedientes";
    }


    //Redirección a la vista de Pacientes de Encargado
    @GetMapping("/encargado/pacientes")
    public String verPacientes( Model model, Principal principal) {
        String correo = principal.getName();
        Encargado encargado = encargadoService.buscarPorCorreo(correo);
        List<Paciente> pacientes = pacienteService.listarPacientes();

        model.addAttribute("encargado", encargado);
        model.addAttribute("pacientes", pacientes);
        model.addAttribute("encargadoNombre", encargado.getNombre());

        return "encargado/encargado_pacientes";
    }

    //Redirección al formulario de Nuevo Paciente de Encargado
    @GetMapping("/encargado/paciente/nuevo")
    public String crearPaciente(Model model, Principal principal){
        String correo = principal.getName();
        Encargado encargado = encargadoService.buscarPorCorreo(correo);

        Paciente paciente = new Paciente();

        model.addAttribute("encargadoNombre", encargado.getNombre());
        model.addAttribute("encargado", encargado);
        model.addAttribute("paciente", paciente);
        return "encargado/paciente_nuevo";
    }

    //Guardado del paciente nuevo
    @PostMapping("/encargado/paciente/guardar")
    public String guardarPaciente(@Valid @ModelAttribute Paciente paciente, BindingResult result, Model model, Principal principal){
        String correo = principal.getName();
        Encargado encargado = encargadoService.buscarPorCorreo(correo);

        model.addAttribute("encargadoNombre", encargado.getNombre());
        model.addAttribute("encargado", encargado);

        if(result.hasErrors()){
            return "encargado/paciente_nuevo";
        }
        if (pacienteService.correoExiste(paciente.getEmail())) {
            result.rejectValue("email", "emailDuplicado", "Este correo ya está registrado");
            return "encargado/paciente_nuevo";
        }
        if (pacienteService.telefonoExiste(paciente.getTelefono())) {
            result.rejectValue("telefono", "telefonoDuplicado", "Este número ya está registrado");
            return "encargado/paciente_nuevo";
        }
        pacienteService.guardar(paciente);
        return "redirect:/encargado/pacientes";
    }

    //Redirección a la vista del doctor
    @GetMapping("/encargado/doctores")
    public String verDoctores(Model model, Principal principal) {

        Encargado encargado = encargadoService.buscarPorCorreo(principal.getName());
        model.addAttribute("encargado", encargado);
        model.addAttribute("encargadoNombre", encargado.getNombre());

        List<Doctor> doctores = doctorService.listarDoctores();
        model.addAttribute("doctores", doctores);

        return "encargado/encargado_doctores";
    }

    //Redirección al formulario del doctor nuevo
    @GetMapping("/encargado/doctor/nuevo")
    public String nuevoDoctor(Model model, Principal principal) {
        model.addAttribute("doctor", new Doctor());

        Encargado encargado = encargadoService.buscarPorCorreo(principal.getName());
        model.addAttribute("encargado", encargado);
        model.addAttribute("encargadoNombre", encargado.getNombre());

        return "encargado/doctor_nuevo";
    }

    // Guardado del nuevo doctor
    @PostMapping("/encargado/doctor/guardar")
    public String guardarDoctor(
            @Valid @ModelAttribute("doctor") Doctor doctor,
            BindingResult result,
            @RequestParam("passwordUsuario") String passwordUsuario,
            Model model,
            Principal principal
    ) {
        Encargado encargado = encargadoService.buscarPorCorreo(principal.getName());
        model.addAttribute("encargado", encargado);
        model.addAttribute("encargadoNombre", encargado.getNombre());

        if (result.hasErrors()) {
            return "encargado/doctor_nuevo";
        }

        if (!passwordUsuario.matches("\\d{4}")) {
            model.addAttribute("errorPassword", "La contraseña debe ser exactamente 4 dígitos");
            return "encargado/doctor_nuevo";
        }

        if (doctorService.correoExiste(doctor.getEmail()) ||
                pacienteService.correoExiste(doctor.getEmail()) ||
                usuarioService.correoExiste(doctor.getEmail())) {

            result.rejectValue("email", "emailDuplicado", "Este correo ya está registrado");
            return "encargado/doctor_nuevo";
        }

        if (doctorService.telefonoExiste(doctor.getTelefono()) ||
                pacienteService.telefonoExiste(doctor.getTelefono())) {

            result.rejectValue("telefono", "telefonoDuplicado", "Este número ya está registrado");
            return "encargado/doctor_nuevo";
        }

        Usuario usuario = new Usuario();
        usuario.setCorreo(doctor.getEmail());
        usuario.setPassword(passwordEncoder.encode(passwordUsuario));
        usuario.setRol("DOCTOR");

        usuario.setDoctor(doctor);
        doctor.setUsuario(usuario);

        usuarioService.guardar(usuario);

        return "redirect:/encargado/doctores";
    }

}
