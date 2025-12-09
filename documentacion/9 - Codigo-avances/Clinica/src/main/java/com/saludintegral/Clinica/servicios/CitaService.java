package com.saludintegral.Clinica.servicios;


import com.saludintegral.Clinica.modelos.Cita;
import com.saludintegral.Clinica.repositorio.CitaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {

    private final CitaRepositorio citaRepositorio;

    public CitaService(CitaRepositorio citaRepositorio) {
        this.citaRepositorio = citaRepositorio;
    }
    public List<Cita> obtenerCitasPendientes() {
        return citaRepositorio.findByEstado("pendiente");
    }
}

