package com.example.Ejercicio1.controladores;

import com.example.Ejercicio1.entidades.Paciente;
import com.example.Ejercicio1.entidades.Profesional;
import com.example.Ejercicio1.servicios.ServiciosProfesional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ControlProfesionales {

    private ServiciosProfesional serviceprof;

    public ControlProfesionales(ServiciosProfesional serviceprof) {
        this.serviceprof = serviceprof;
    }

    @PutMapping("/profesionales/{id}")
    public RedirectView actualizarProfesional(@PathVariable Long id, Profesional actualizarProf){
        this.serviceprof.actualizar(id, actualizarProf);
        return new RedirectView("/profesionales");
    }

    @PostMapping("/profesionales")
    //cambiar paciente por redirecttview
    public RedirectView crearPaciente(@ModelAttribute Profesional p, Model model){
        model.addAttribute(p);
        this.serviceprof.crearProfesionales(p);
        return new RedirectView("/profesionales");
    }

}
