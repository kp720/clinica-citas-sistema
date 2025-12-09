package com.saludintegral.Clinica.modelos;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Integer id;

    private LocalDate fecha;
    private LocalTime hora;
    private String tipo;

    @Column(nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "fk_id_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "fk_id_doctor")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "fk_id_encargado")
    private Encargado encargado;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Encargado getEncargado() {
        return encargado;
    }
    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }
}
