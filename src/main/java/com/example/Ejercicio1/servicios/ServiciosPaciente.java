package com.example.Ejercicio1.servicios;

import com.example.Ejercicio1.entidades.Paciente;
import com.example.Ejercicio1.repositorios.repositorioPacientes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciosPaciente {
    /*
    Paciente p1;
    Paciente p2;
    List<Paciente> listaPacientes;

    ServiciosProfesional prof = new ServiciosProfesional();


     */
    private repositorioPacientes repositorioP;

    //constructor

    public ServiciosPaciente(repositorioPacientes repositorioP) {
        this.repositorioP = repositorioP;
    }

    /*
    public ServiciosPaciente() {

        Profesional n1 = this.prof.m1;
        this.p1 = new Paciente("Carlos", 23, 123456,
                3115655, "Enfermedad estomacal", n1);
        this.p2 = new Paciente("Manuela", 36, 126876,
                310255, "Depresión",null);
        this.listaPacientes = new ArrayList<>();
        listaPacientes.add(p1);
        listaPacientes.add(p2);


    }
    */
        //mostrar los pacientes
        public List<Paciente> getListaPacientes(){
            return this.repositorioP.findAll();
        }

        //nuevo por id
    public Paciente getPaciente(Long id){
            return this.repositorioP.findById(id).orElseThrow();
    }

        //crear pacientes
        public Paciente crearPaciente(Paciente nuevoPaciente){
            return this.repositorioP.save(nuevoPaciente);
        }

        public Paciente actualizar(Long id, Paciente p) {
            //Optional<Paciente> actual2 = this.repositorioP.findById(id);
            //actual2.get().setNombre(p.getNombre());
            //return this.repositorioP.save(actual2.get());

            Paciente actual = repositorioP.findById(id).orElseThrow();
            //actual.setDocumentoIdentidad(p.getDocumentoIdentidad());
            actual.setNombre(p.getNombre());
            actual.setEdad(p.getEdad());
            actual.setTelefono(p.getTelefono());
            actual.setDescripcionEnfermedad(p.getDescripcionEnfermedad());
            actual.setProfesionales(p.getProfesionales());
            return this.repositorioP.save(actual);

        }


        public Paciente eliminarPaciente(Long pId){
            Paciente actual = repositorioP.findById(pId).orElseThrow();
            this.repositorioP.deleteById(pId);
            return actual;
        }


        /*
        public Paciente getPaciente(){
            return p1;
        }
         */

}
