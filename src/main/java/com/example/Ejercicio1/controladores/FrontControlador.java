package com.example.Ejercicio1.controladores;

import com.example.Ejercicio1.entidades.Paciente;
import com.example.Ejercicio1.entidades.Usuario;
import com.example.Ejercicio1.servicios.ServiciosPaciente;
import com.example.Ejercicio1.servicios.ServiciosUsuario;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FrontControlador {

    ServiciosPaciente servicesP;
    public FrontControlador(ServiciosPaciente servicesP, ServiciosUsuario servicesU){
        this.servicesP = servicesP;
        this.servicesU = servicesU;
    }

        //NUEVO PARA LOS USUARIOS OJOJOJOJOJO  recuerde incluir el servicioUsuarios en el consctrcutos

    ServiciosUsuario servicesU;


    @GetMapping("/") //ruta raiz
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){
                //para ensayar
        if (principal != null){
            //System.out.println(principal.getClaims()); lo quito cuando vean los datos
            Usuario usuario = this.servicesU.getOrCreateUsuario(principal.getClaims());
            //esto se agrega al final para visdualizar el usuario en la pagina
            model.addAttribute("usuario", usuario);

        }
        return "index";
    }

    /*
     @GetMapping("/") //ruta raiz
    public String index(){
        return "index";
    }
     */
//@DateTimeFormat(pattern = "YYYY-MM-DD") para poder ver la fecha
    @GetMapping("/pacientes")
    public String pacientes(Model model){
        List<Paciente> pacientes = this.servicesP.getListaPacientes();
        model.addAttribute("pacientes",pacientes);
        return "pacientes";
    }

    @GetMapping("/pacientes/nuevo")
    public String nuevoPaciente(Model model){
        model.addAttribute("paciente", new Paciente());
        return "nuevo-paciente";
    }

    @GetMapping("/pacientes/{id}")
    public String actualizarPaciente(@PathVariable Long id, Model model){
        Paciente pacienteFind = this.servicesP.getPaciente(id);
        model.addAttribute("pacienteFind", pacienteFind);
        return "actualizar-paciente";
    }


}
