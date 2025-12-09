package com.saludintegral.Clinica.controlador;

import com.saludintegral.Clinica.modelos.Cita;
import com.saludintegral.Clinica.servicios.CitaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping("/doctor/citas")
    public String verCitasPendientes(Model model) {
        List<Cita> citasPendientes = citaService.obtenerCitasPendientes();
        model.addAttribute("citas", citasPendientes);
        return "doctor_citas";  // Nombre del archivo HTML
    }
}
