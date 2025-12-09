package com.saludintegral.Clinica.servicios;

import com.saludintegral.Clinica.modelos.Usuario;
import com.saludintegral.Clinica.repositorio.UsuarioRepositorio;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepositorio usuarioRepositorio;

    //Constructor
    public UsuarioService(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    //Metodo que autentifica al usuario desde la BD
    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return User.builder()
                .username(usuario.getCorreo())
                .password(usuario.getPassword())
                .roles(usuario.getRol())
                .build();
    }

    //Busqueda de usuarios por correo
    public Usuario buscarPorCorreo(String correo) {
        return usuarioRepositorio.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
}

    public boolean correoExiste(String email){
        return usuarioRepositorio.existsByCorreo(email);
    }

    public Usuario guardar(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }
}

