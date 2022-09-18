package com.example.Ejercicio1.servicios;

import com.example.Ejercicio1.entidades.Profesional;
import com.example.Ejercicio1.entidades.Servicio;
import com.example.Ejercicio1.repositorios.repositorioPacientes;
import com.example.Ejercicio1.repositorios.repositorioProfesionales;
import org.springframework.stereotype.Service;

@Service
public class ServiciosProfesional {
    /*Profesional m1;
    ServiciosServicios ss1 = new ServiciosServicios();

    public ServiciosProfesional(){
        Servicio serviciosPrestados = this.ss1.s1;
        this.m1 = new Profesional("Miguel", 12345,"Psicólogo",serviciosPrestados);
    }
     */

    private repositorioProfesionales repositorioProf;

    //cosntructot
    public ServiciosProfesional(repositorioProfesionales repositorioProf) {
        this.repositorioProf = repositorioProf;
    }



}
