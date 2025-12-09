package com.saludintegral.Clinica.modelos;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_actividad")
public class LogActividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_log;

    private LocalDateTime fecha;

    private String usuario;

    private String accion;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    public LogActividad() {}

    public LogActividad(String usuario, String accion, String descripcion) {
        this.fecha = LocalDateTime.now();
        this.usuario = usuario;
        this.accion = accion;
        this.descripcion = descripcion;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setId_log(int id_log) {
        this.id_log = id_log;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getAccion() {
        return accion;
    }

    public int getId_log() {
        return id_log;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUsuario() {
        return usuario;
    }
}
