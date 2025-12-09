package com.saludintegral.Clinica.controlador;

import com.saludintegral.Clinica.modelos.Cita;
import com.saludintegral.Clinica.repositorio.CitaRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DoctorController {

    private final CitaRepositorio citaRepositorio;

    public DoctorController(CitaRepositorio citaRepositorio) {
        this.citaRepositorio = citaRepositorio;
    }

}
