package com.example.Ejercicio1.servicios;

import com.example.Ejercicio1.entidades.Paciente;
import com.example.Ejercicio1.entidades.Servicio;
import com.example.Ejercicio1.repositorios.repositorioServicios;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosServicios {
   /* Servicio s1;

    public ServiciosServicios(){
        this.s1 = new Servicio(true,"Enfermedad General", "Hiosina","OK");
    }

   */

    private repositorioServicios repositorioSer;

    //constructor
    public ServiciosServicios(repositorioServicios repositorioSer){
        this.repositorioSer = repositorioSer;
    }
    //mostrat serivios
    public List<Servicio> getListaServicios(){
        return this.repositorioSer.findAll();
    }

    public Servicio getServicios( Long id){
        return this.repositorioSer.findById(id).orElseThrow();
    }

    //crear servicios
    public Servicio crearServicio(Servicio nuevoServicio){
        return this.repositorioSer.save(nuevoServicio);
    }
}
