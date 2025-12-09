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
    private String password;

    @NotBlank
    private String rol;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Doctor doctor;

    public void setRol(String rol) {
        this.rol = rol;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setDoctor(Doctor doctor) {this.doctor = doctor;}

    public int getId_usuario() {
        return id_usuario;
    }
    public String getCorreo() {
        return correo;
    }
    public String getPassword() {
        return password;
    }
    public String getRol() {
        return rol;
    }
    public Doctor getDoctor() {return doctor;}
}
