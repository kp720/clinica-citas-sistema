package com.saludintegral.Clinica.modelos;

import jakarta.persistence.*;

@Entity
public class Expediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_expediente;

    private String diagnosticos;
    private String recetas;
    private String tratamientos;
    private String observaciones;
    private String estado_expediente;

    @ManyToOne
    @JoinColumn(name = "fk_id_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "fk_id_doctor")
    private Doctor doctor;
}
