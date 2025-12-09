package com.saludintegral.Clinica.repositorio;

import com.saludintegral.Clinica.modelos.Encargado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EncargadoRepositorio extends JpaRepository<Encargado, Integer> {

    @Query("SELECT d FROM Encargado d WHERE d.usuario.id_usuario = :idUsuario")
    Encargado findByUsuarioIdUsuario(@Param("idUsuario") int idUsuario);

    Encargado findByUsuarioCorreo(String correo);
}
