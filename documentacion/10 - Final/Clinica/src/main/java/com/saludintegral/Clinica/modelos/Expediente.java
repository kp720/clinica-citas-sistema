package com.saludintegral.Clinica.modelos;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Expediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_expediente;

    private String diagnosticos;
    private String recetas;
    private String tratamientos;
    private String observaciones;

    @Column(name = "estado_expediente")
    private String estadoExpediente;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "fk_id_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "fk_id_doctor")
    private Doctor doctor;

    public int getId_expediente() { return id_expediente; }
    public void setId_expediente(int id_expediente) { this.id_expediente = id_expediente; }

    public String getDiagnosticos() { return diagnosticos; }
    public void setDiagnosticos(String diagnosticos) { this.diagnosticos = diagnosticos; }

    public String getRecetas() { return recetas; }
    public void setRecetas(String recetas) { this.recetas = recetas; }

    public String getTratamientos() { return tratamientos; }
    public void setTratamientos(String tratamientos) { this.tratamientos = tratamientos; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public String getEstadoExpediente() { return estadoExpediente; }
    public void setEstadoExpediente(String estadoExpediente) { this.estadoExpediente = estadoExpediente; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}

