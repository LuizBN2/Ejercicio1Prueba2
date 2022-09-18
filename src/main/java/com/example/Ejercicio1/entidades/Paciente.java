package com.example.Ejercicio1.entidades;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name="pacientesAAA")
public class Paciente {

    //atributos
  //esto se va a cambiar por el documentos de identidad de mas abajo y esta col desaparece
   /* @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long Id;

    */

    @Id
    public Long documentoIdentidad;
    @Column(name="nombre")
    private String nombre;
    @Column(name="edad")
    private Integer edad;

    @Column(name="telefono")
    private Integer telefono;
    @Column(name="descripcionEnfermedad")
    private String descripcionEnfermedad;

    //nuevo
    @ManyToOne(optional = false)
    @JoinColumn(name = "registroMedico")
    @JsonIgnoreProperties(value="registroMedico")
    private Profesional profesionales;

    public Profesional getProfesionales() {
        return profesionales;
    }

    public void setProfesionales(Profesional profesionales) {
        this.profesionales = profesionales;
    }

    //constructor
    public Paciente(){
    }
    public Paciente(String nombre, Integer edad, Long documentoIdentidad, Integer telefono, String descripcionEnfermedad, Long registroMedico) {
        this.nombre = nombre;
        this.edad = edad;
        this.documentoIdentidad = documentoIdentidad;
        this.telefono = telefono;
        this.descripcionEnfermedad = descripcionEnfermedad;
        this.profesionales.setRegistroMedico(registroMedico);
        //this.profesionales = profesionales;
    }
  /*  public Paciente(String nombre, Integer edad, Long documentoIdentidad, Integer telefono, String descripcionEnfermedad, Profesional profesionales) {
        this.nombre = nombre;
        this.edad = edad;
        this.documentoIdentidad = documentoIdentidad;
        this.telefono = telefono;
        this.descripcionEnfermedad = descripcionEnfermedad;
        this.profesionales = profesionales;
    }

   */


    //getters and setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Long getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(Long documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getDescripcionEnfermedad() {
        return descripcionEnfermedad;
    }

    public void setDescripcionEnfermedad(String descripcionEnfermedad) {
        this.descripcionEnfermedad = descripcionEnfermedad;
    }
/*
    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", documentoIdentidad=" + documentoIdentidad +
                ", telefono=" + telefono +
                ", descripcionEnfermedad='" + descripcionEnfermedad + '\'' +
                ", profesionales=" + profesionales +
                '}';
    }

 */
}
