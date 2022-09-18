package com.example.Ejercicio1.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="profesionalesAAA")
public class Profesional {
    //esto se va a modificar como en en pacientes
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
     */

    @Id
    @JsonIgnoreProperties(value = "profesionales")
    private Long registroMedico;
    @Column(name="nombreMedico")
    private String nombreMedico;

    @Column(name="profesion")
    private String profesion;
    //@ManyToOne(optional = true)
    @OneToMany(mappedBy = "profesionales")
    //@JoinColumn(name = "registroAtencion")
    private Set<Servicio> servicios;

    public void setServicios(Set<Servicio> servicios) {
        this.servicios = servicios;
    }

    public Set<Servicio> getServicios() {
        return servicios;
    }

    public Profesional() {
    }
//server.port=8090
    /*
    public Profesional(String nombreMedico, Long registroMedico, String profesion, Long registroAtencion) {
        this.nombreMedico = nombreMedico;
        this.registroMedico = registroMedico;
        this.profesion = profesion;
        this.servicios.setRegistroAtencion(registroAtencion);
        //this.servicios = servicios;
    }

     */


//getters and setters




    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public Long getRegistroMedico() {
        return registroMedico;
    }

    public void setRegistroMedico(Long registroMedico) {
        this.registroMedico = registroMedico;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
/*
    @Override
    public String toString() {
        return "Profesional{" +
                "nombreMedico='" + nombreMedico + '\'' +
                ", registroMedico=" + registroMedico +
                ", profesion='" + profesion + '\'' +
                ", servicios=" + servicios +
                '}';
    }

 */
}
