package com.example.Ejercicio1.controladores;

import com.example.Ejercicio1.entidades.Paciente;
import com.example.Ejercicio1.entidades.Servicio;
import com.example.Ejercicio1.servicios.ServiciosServicios;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControlServicios {

    ServiciosServicios services;

    public ControlServicios(ServiciosServicios servicesS){
        this.services = servicesS;
    }

    //mostrar
    @GetMapping("/servicios")
    public List<Servicio> listaServicios(){
        return this.services.getListaServicios();
    }

    @GetMapping("/serviciosby/{id}")
    public Servicio Servicios(@PathVariable Long id){
        return this.services.getServicios(id);
    }

    //crear
    @PostMapping("/servicios")
    public Servicio crearServicio(@RequestBody Servicio s){
        return this.services.crearServicio(s);
    }
}
