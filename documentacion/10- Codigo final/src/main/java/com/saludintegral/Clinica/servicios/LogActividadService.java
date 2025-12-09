package com.saludintegral.Clinica.servicios;

import com.saludintegral.Clinica.modelos.LogActividad;
import com.saludintegral.Clinica.repositorio.LogActividadRepositorio;
import org.springframework.stereotype.Service;

@Service
public class LogActividadService {

    private final LogActividadRepositorio repo;

    public LogActividadService(LogActividadRepositorio repo) {
        this.repo = repo;
    }

    public void registrar(String usuario, String accion, String descripcion) {
        LogActividad log = new LogActividad(usuario, accion, descripcion);
        repo.save(log);
    }
}

