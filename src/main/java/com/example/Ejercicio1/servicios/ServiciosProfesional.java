package com.example.Ejercicio1.servicios;

import com.example.Ejercicio1.entidades.Paciente;
import com.example.Ejercicio1.entidades.Profesional;
import com.example.Ejercicio1.entidades.Servicio;
import com.example.Ejercicio1.repositorios.repositorioPacientes;
import com.example.Ejercicio1.repositorios.repositorioProfesionales;
import org.apache.maven.lifecycle.internal.LifecycleStarter;
import org.hibernate.dialect.LobMergeStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Profesional> getListaProfesionales(){
        return this.repositorioProf.findAll();
    }

    public Profesional getProfesional(Long id){
        return this.repositorioProf.findById(id).orElseThrow();
    }


    //crear profesionales
    public Profesional crearProfesionales(Profesional nuevoProfesional){
        return this.repositorioProf.save(nuevoProfesional);
    }

    public Profesional actualizar(Long id, Profesional p) {
        //Optional<Paciente> actual2 = this.repositorioP.findById(id);
        //actual2.get().setNombre(p.getNombre());
        //return this.repositorioP.save(actual2.get());

        Profesional actual = repositorioProf.findById(id).orElseThrow();
        actual.setNombreMedico(p.getNombreMedico());
        actual.setProfesion(p.getProfesion());
        return this.repositorioProf.save(actual);

    }

}
