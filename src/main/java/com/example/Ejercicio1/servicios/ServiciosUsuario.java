package com.example.Ejercicio1.servicios;


import com.example.Ejercicio1.entidades.Usuario;
import com.example.Ejercicio1.repositorios.repositorioUsuarios;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ServiciosUsuario {
    private repositorioUsuarios repositorioUs;

    //constructor
    public ServiciosUsuario(repositorioUsuarios repositorioUs){
        this.repositorioUs = repositorioUs;
    }

    //funcipón publica para crea un usuario


    public Usuario crearUsuario(Usuario nuevoUsuario){
       return this.repositorioUs.save(nuevoUsuario);
    }

    //esto despues de crear, para buscar que exista
    public Usuario buscarPorEmail(String email){
       return this.repositorioUs.findByEmail(email);
    }

    public Usuario getOrCreateUsuario(Map<String, Object> DatosUsuario){
        String email = (String) DatosUsuario.get("email");

        //esto se hace luego de explicar el funcionamiento del sistema sin búsqueda de usuarios

        Usuario usuario = buscarPorEmail(email);
        if (usuario == null){
            String alias = (String)  DatosUsuario.get("nickname");
            String imagen = (String) DatosUsuario.get("picture");
            String auth0Id = (String) DatosUsuario.get("sub");

            Usuario nuevoUsuario = new Usuario(email=email,imagen=imagen,auth0Id=auth0Id);
            return crearUsuario(nuevoUsuario);
        }
        System.out.println(usuario.getEmail());
        return usuario;

    }




}
