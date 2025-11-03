package com.saludintegral.Clinica.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class LogActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_log;

    private String accion;
    private String tabla_afectada;
    private String descripcion;
    private LocalDateTime fecha;
}