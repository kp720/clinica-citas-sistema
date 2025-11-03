package com.saludintegral.Clinica.controlador;

import com.saludintegral.Clinica.modelos.Cita;
import com.saludintegral.Clinica.servicios.CitaService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/doctor/home")
    public String doctorHome(Model model, Authentication auth) {
        model.addAttribute("doctorNombre", auth.getName());
        return "doctor_inicio";
    }

    @GetMapping("/admin/home")
    public String adminHome(Model model, Authentication auth) {
        model.addAttribute("adminNombre", auth.getName());
        return "admin_inicio";
    }

    @GetMapping("/encargado/home")
    public String encargadoHome(Model model, Authentication auth) {
        model.addAttribute("encargadoNombre", auth.getName());
        return "encargado_inicio";
    }
}