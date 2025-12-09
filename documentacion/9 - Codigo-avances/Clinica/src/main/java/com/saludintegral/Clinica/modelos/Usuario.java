package com.saludintegral.Clinica.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;

    @Email
    @NotBlank
    private String correo;

    @NotBlank
    private String contraseña;

    @NotBlank
    private String rol;

    public void setRol(String rol) {
        this.rol = rol;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId_usuario() {
        return id_usuario;
    }
    public String getCorreo() {
        return correo;
    }
    public String getContraseña() {
        return contraseña;
    }
    public String getRol() {
        return rol;
    }
}