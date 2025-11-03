package com.saludintegral.Clinica.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_doctor;

    private String nombre;
    private String especialidad;
    private String horario_disponible;
    private String telefono;
    private String email;
}