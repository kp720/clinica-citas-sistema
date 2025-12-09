package com.saludintegral.Clinica.modelos;

import jakarta.persistence.*;

@Entity
public class Encargado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_encargado;

    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

    private String nombre;
    private String telefono;
    private String turno;


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setId_encargado(int id_encargado) {
        this.id_encargado = id_encargado;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId_encargado() {
        return id_encargado;
    }

    public String getTurno() {
        return turno;
    }
}
