package com.example.Ejercicio1.controladores;

import com.example.Ejercicio1.entidades.Paciente;
import com.example.Ejercicio1.servicios.ServiciosPaciente;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class ControlPacientes {
    //pruebas de visualización
    @GetMapping("/pruebas")
    public String visualizar(){
        return "Prueba visual de pacientes en Intellij";
    }

    /*
    @GetMapping("/pacientes2")
    public Paciente ControlPacientesPrueba(){

        //Esto se hace inicialmente para probar
        //una vez construido el servicio (ServiciosPAciente) se puede quitar y poner lo de más abajo


        Paciente p1 = new Paciente("Carlos",23,123456,3115655,
                "Enfermedad estomacal", null);
        return p1;



        //Esto....
        //creamos una instancvia a ese servivio, para acceder al servicio dentro del constructor

    }
    */

    //cosntructor
    ServiciosPaciente services;

    public ControlPacientes(ServiciosPaciente servicesP){
        this.services = servicesP;
    }

//era igual al que había
    /*
    @GetMapping("/pacientes")
    public List<Paciente> listaPacientes(){
        return this.services.getListaPacientes();
    }

     */

    @PostMapping("/pacientes")
    //cambiar paciente por redirecttview
    public RedirectView crearPaciente(@ModelAttribute Paciente p, Model model){
        model.addAttribute(p);
        this.services.crearPaciente(p);
        return new RedirectView("/pacientes");
    }

    @DeleteMapping("/pacientes/{id}")
    public RedirectView eliminarP(@PathVariable Long id){
        this.services.eliminarPaciente(id);
        return new RedirectView("/pacientes");
    }

    /*
     @DeleteMapping("/pacientes/{id}")
    public Paciente eliminarP(@PathVariable(value = "id") Long id){
        //this.services.eliminarPaciente(id);
        return this.services.eliminarPaciente(id);
    }
     */

    @PutMapping("/pacientes/{id}")
    public RedirectView actualizarPaciente(@PathVariable Long id, Paciente actualizarP){
        this.services.actualizar(id, actualizarP);
        return new RedirectView("/pacientes");
    }


/*
    public Paciente actualizarPaciente(@PathVariable Long id,@RequestBody Paciente actPaciente) {
        System.out.println(actPaciente.getNombre());
        return this.services.actualizar(id, actPaciente);
    }

 */


    /*
    @GetMapping("/pruebas2")
    public List<Paciente> visualizar2(){
        return this.services.getListaPacientes();
    }

     */



}
