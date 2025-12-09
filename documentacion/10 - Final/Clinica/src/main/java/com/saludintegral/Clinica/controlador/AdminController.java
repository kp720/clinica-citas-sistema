package com.saludintegral.Clinica.controlador;

import com.saludintegral.Clinica.modelos.*;
import com.saludintegral.Clinica.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private final CitaService citaService;

    @Autowired
    private final DoctorService doctorService;

    @Autowired
    private final ExpedienteService expedienteService;

    @Autowired
    private final PacienteService pacienteService;

    @Autowired
    private final UsuarioService usuarioService;

    @Autowired
    private final EncargadoService encargadoService;

    //Contructor
    public AdminController (CitaService citaService, DoctorService doctorService, ExpedienteService expedienteService, PacienteService pacienteService, UsuarioService usuarioService, EncargadoService encargadoService){
        this.citaService = citaService;
        this.doctorService = doctorService;
        this.expedienteService = expedienteService;
        this.pacienteService = pacienteService;
        this.usuarioService = usuarioService;
        this.encargadoService = encargadoService;
    }

   //Redirección a la vista de Inicio de Administrador
    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        model.addAttribute("adminNombre", principal.getName());
        return "admin_inicio";
    }

    @GetMapping("/citas")
    public String listarCitas(Model model, Principal principal) {

        List<Cita> citas = citaService.listarTodas();

        model.addAttribute("adminNombre", principal.getName());
        model.addAttribute("citas", citas);

        return "admin_citas";
    }

    @GetMapping("/doctores")
    public String listarDoctores(Model model, Principal principal) {

        List<Doctor> doctores = doctorService.listarDoctores();

        model.addAttribute("adminNombre", principal.getName());
        model.addAttribute("doctores", doctores);

        return "admin_doctores";
    }

    @GetMapping("/pacientes")
    public String listarPacientes(Model model, Principal principal) {

        List<Paciente> pacientes = pacienteService.listarPacientes();

        model.addAttribute("adminNombre", principal.getName());
        model.addAttribute("pacientes", pacientes);

        return "admin_pacientes";
    }

    @GetMapping("/expedientes")
    public String listarExpedientes(Model model, Principal principal) {

        List<Expediente> expedientes = expedienteService.listarTodos();
        model.addAttribute("adminNombre", principal.getName());
        model.addAttribute("expedientes", expedientes);

        return "admin_expedientes";
    }

    @GetMapping("/cita/nueva")
    public String nuevaCita(Model model) {

        Cita cita = new Cita();
        cita.setPaciente(new Paciente());
        cita.setDoctor(new Doctor());

        model.addAttribute("titulo", "Registrar Nueva Cita");
        model.addAttribute("cita", cita);
        model.addAttribute("doctores", doctorService.listarDoctores());
        model.addAttribute("pacientes", pacienteService.listarPacientes());

        return "modCitas/cita_nueva";
    }


    @GetMapping("/admin/citas/modificar/{id}")
    public String mostrarModificarCita(@PathVariable("id") int id, Model model) {
        Cita cita = citaService.buscarPorId(id);
        model.addAttribute("cita", cita);
        model.addAttribute("pacientes", pacienteService.listarPacientes());
        model.addAttribute("doctores", doctorService.listarDoctores());
        model.addAttribute("encargados", encargadoService.listarTodos());
        return "modCitas/cita_modificar";
    }

    @PostMapping("/admin/citas/modificar")
    public String modificarCita(@ModelAttribute("cita") Cita citaActualizada) {

        return "redirect:/admin/citas?editSuccess";
    }


    @PostMapping("/citas/guardar")
    public String guardarCita(@ModelAttribute Cita cita, Principal principal) {

        Encargado e = encargadoService.buscarPorUsuario(principal.getName());
        cita.setEncargado(e);

        citaService.guardar(cita);
        return "redirect:/admin_citas";
    }

    @PostMapping("/citas/actualizar")
    public String actualizarCita(@ModelAttribute Cita cita, Principal principal) {

        Encargado encargado = encargadoService.buscarPorUsuario(principal.getName());
        cita.setEncargado(encargado);

        citaService.guardar(cita);
        return "redirect:/admin_citas";
    }

    @GetMapping("/admin/citas/eliminar/{id}")
    public String eliminarCita(@PathVariable int id) {
        citaService.eliminar(id);
        return "redirect:/admin_citas";
    }

    @GetMapping("/admin/citas/ver/{id}")
    public String verCita(@PathVariable("id") int idCita, Model model) {
        Cita cita = citaService.buscarPorId(idCita);
        model.addAttribute("cita", cita);
        return "modCitas/verCita";
    }

}

