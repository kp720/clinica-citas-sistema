package com.saludintegral.Clinica.controlador;

import com.saludintegral.Clinica.modelos.Expediente;
import com.saludintegral.Clinica.servicios.ExpedienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/expedientes")
public class ExpedienteController {

    private final ExpedienteService expedienteService;

    public ExpedienteController(ExpedienteService expedienteService) {
        this.expedienteService = expedienteService;
    }

    @GetMapping
    public String listarExpedientes(Model model) {
        model.addAttribute("expedientes", expedienteService.listarTodos());
        return "doctor_expedientes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarExpediente(@PathVariable int id) {
        expedienteService.eliminar(id);
        return "redirect:doctor_expedientes";
    }
}
