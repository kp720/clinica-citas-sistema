package com.saludintegral.Clinica.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doctor")
    private Integer idDoctor;

    @NotBlank(message = "Ingrese el nombre del doctor")
    private String nombre;

    @NotBlank(message = "Ingrese la especialidad")
    private String especialidad;

    @NotBlank(message = "Ingrese el horario disponible")
    private String horario_disponible;

    @NotBlank(message = "Ingrese un número de teléfono")
    private String telefono;

    @Email(message = "Ingrese un correo válido")
    @NotBlank(message = "Ingrese un correo")
    private String email;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;


    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getHorario_disponible() { return horario_disponible; }
    public void setHorario_disponible(String horario_disponible) { this.horario_disponible = horario_disponible; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
