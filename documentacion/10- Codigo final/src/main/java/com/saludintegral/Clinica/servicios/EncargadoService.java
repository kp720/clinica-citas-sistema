package com.saludintegral.Clinica.servicios;

import com.saludintegral.Clinica.modelos.Cita;
import com.saludintegral.Clinica.modelos.Doctor;
import com.saludintegral.Clinica.modelos.Encargado;
import com.saludintegral.Clinica.modelos.Usuario;
import com.saludintegral.Clinica.repositorio.CitaRepositorio;
import com.saludintegral.Clinica.repositorio.DoctorRepositorio;
import com.saludintegral.Clinica.repositorio.EncargadoRepositorio;
import com.saludintegral.Clinica.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EncargadoService {

    @Autowired
    private final EncargadoRepositorio encargadoRepositorio;
    @Autowired
    private final UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private final CitaRepositorio citaRepositorio;
    @Autowired
    private final DoctorRepositorio doctorRepositorio;

    public EncargadoService(EncargadoRepositorio encargadoRepositorio, UsuarioRepositorio usuarioRepositorio, CitaRepositorio citaRepositorio, DoctorRepositorio doctorRepositorio){
        this.encargadoRepositorio = encargadoRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
        this.citaRepositorio = citaRepositorio;
        this.doctorRepositorio = doctorRepositorio;
    }

    public List<Encargado> listarTodos(){
        return encargadoRepositorio.findAll();
    }

    public Encargado buscarPorId(int IdEncargado){
        return encargadoRepositorio.findById(IdEncargado).orElse(null);
    }

    public void guardar (Encargado encargado){
        encargadoRepositorio.save(encargado);
    }

    public void eliminar (int IdEncargado){
        encargadoRepositorio.deleteById(IdEncargado);
    }

    public Encargado buscarPorUsuario(String correo){
        return encargadoRepositorio.findByUsuarioCorreo(correo);
    }

    public Encargado buscarPorCorreo(String correo) {
        Usuario usuario = usuarioRepositorio.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        if (usuario == null) {
            return null;
        }
        return encargadoRepositorio.findByUsuarioIdUsuario(usuario.getId_usuario());
    }

    public List<Cita> buscarPorEncargado(Encargado encargado) {
        return citaRepositorio.findByEncargado(encargado);
    }

}
