package com.saludintegral.Clinica.repositorio;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saludintegral.Clinica.modelos.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    //Metodo de busqueda de usuario por correo
    Optional <Usuario> findByCorreo(String correo);

    boolean existsByCorreo(String email);
}