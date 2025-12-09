package com.saludintegral.Clinica.servicios;

import com.saludintegral.Clinica.dto.DoctorDTO;
import com.saludintegral.Clinica.modelos.Cita;
import com.saludintegral.Clinica.modelos.Doctor;
import com.saludintegral.Clinica.modelos.Usuario;
import com.saludintegral.Clinica.repositorio.CitaRepositorio;
import com.saludintegral.Clinica.repositorio.DoctorRepositorio;
import com.saludintegral.Clinica.repositorio.UsuarioRepositorio;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private final DoctorRepositorio doctorRepositorio;

    @Autowired
    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private final CitaRepositorio citaRepositorio;

    public DoctorService(DoctorRepositorio doctorRepositorio, UsuarioRepositorio usuarioRepositorio, CitaRepositorio citaRepositorio) {
        this.doctorRepositorio = doctorRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
        this.citaRepositorio = citaRepositorio;
    }

    public List<Doctor> listarDoctores() {
        return doctorRepositorio.findAll();
    }

    public Doctor buscarPorId(int IdDoctor) {
        return doctorRepositorio.findById(IdDoctor).orElse(null);
    }

    public Doctor buscarPorIdUsuario(int idUsuario) {
        return doctorRepositorio.findByUsuarioIdUsuario(idUsuario);
    }

    public Doctor buscarPorCorreo(String correo) {
        Usuario usuario = usuarioRepositorio.findByCorreo(correo)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        if (usuario == null) {
            return null;
        }
        return doctorRepositorio.findByUsuarioIdUsuario(usuario.getId_usuario());
    }

    public List<DoctorDTO> buscarDoctoresDisponibles(LocalDate fecha, LocalTime hora) {

        List<Doctor> todos = doctorRepositorio.findAll();
        List<Cita> ocupadas = citaRepositorio.findByFechaAndHora(fecha, hora);

        Set<Integer> idsOcupados = ocupadas.stream()
                .map(c -> c.getDoctor().getIdDoctor())
                .collect(Collectors.toSet());

        return todos.stream()
                .filter(d -> !idsOcupados.contains(d.getIdDoctor()))
                .filter(d -> estaEnHorario(d.getHorario_disponible(), hora))
                .map(d -> new DoctorDTO(
                        d.getIdDoctor(),
                        d.getNombre(),
                        d.getEspecialidad(),
                        d.getHorario_disponible()
                ))
                .collect(Collectors.toList());
    }

    private boolean estaEnHorario(String horario, LocalTime hora) {

        if (horario == null || !horario.contains("-")) {
            return false;
        }

        try {
            String[] partes = horario.split("-");

            LocalTime inicio = LocalTime.parse(partes[0].trim());
            LocalTime fin = LocalTime.parse(partes[1].trim());

            return !hora.isBefore(inicio) && !hora.isAfter(fin);

        } catch (Exception e) {
            return false;
        }
    }

    public boolean correoExiste(String email){
        return doctorRepositorio.existsByEmail(email);
    }
    public boolean telefonoExiste(String telefono){
        return doctorRepositorio.existsByTelefono(telefono);
    }



    public void guardar(Doctor doctor){
        doctorRepositorio.save(doctor);
    }
    public void eliminar(int IdDoctor){
        doctorRepositorio.deleteById(IdDoctor);
    }


}