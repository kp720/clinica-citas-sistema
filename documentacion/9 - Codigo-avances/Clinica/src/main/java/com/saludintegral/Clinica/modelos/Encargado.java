package com.saludintegral.Clinica.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Encargado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_encargado;

    private String nombre;
    private String telefono;
    private String turno;
}
