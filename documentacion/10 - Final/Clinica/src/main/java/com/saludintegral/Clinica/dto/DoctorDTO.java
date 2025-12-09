package com.saludintegral.Clinica.dto;

public class DoctorDTO {

    private Integer idDoctor;
    private String nombre;
    private String especialidad;
    private String horarioDisponible;

    public DoctorDTO(Integer idDoctor, String nombre, String especialidad, String horarioDisponible) {
        this.idDoctor = idDoctor;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.horarioDisponible = horarioDisponible;
    }

    public Integer getIdDoctor() { return idDoctor; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public String getHorarioDisponible() { return horarioDisponible; }
}
