package com.saludintegral.Clinica.servicios;

import com.saludintegral.Clinica.modelos.Paciente;
import com.saludintegral.Clinica.repositorio.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    public List<Paciente> listarPacientes() {
        return pacienteRepositorio.findAll();
    }

    public Paciente buscarPorId(int id) {
        return pacienteRepositorio.findById(id).orElse(null);
    }

    public boolean correoExiste(String email){
        return pacienteRepositorio.existsByEmail(email);
    }

    public boolean telefonoExiste(String telefono){
        return pacienteRepositorio.existsByTelefono(telefono);
    }

    public void guardar(Paciente paciente) {
        pacienteRepositorio.save(paciente);
    }

    public void eliminar(int id) {
        pacienteRepositorio.deleteById(id);
    }
}
