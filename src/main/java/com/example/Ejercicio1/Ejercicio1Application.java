package com.example.Ejercicio1;

import com.example.Ejercicio1.entidades.Paciente;
import com.example.Ejercicio1.entidades.Profesional;
import com.example.Ejercicio1.entidades.Servicio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Ejercicio1Application {

	public static void main(String[] args) {

		SpringApplication.run(Ejercicio1Application.class, args);

		/*Servicio s1 = new Servicio(true,"Enfermedad General", "Hiosina","OK");

		Profesional m1 = new Profesional("Miguel", 12345,"Psicólogo",s1);

		Paciente p1 = new Paciente("Carlos",23,123456,3115655,"Enfermedad estomacal",
				m1);

		Paciente p2 = new Paciente("Manuela",36,126876,310255,"Depresión",
				null);

		List<Paciente> listaPacientes = new ArrayList<>();


		listaPacientes.add(p1);
		listaPacientes.add(p2);

		//System.out.println(listaPacientes.toString());

		for (int i = 0; i < listaPacientes.size(); i++){
			System.out.println(listaPacientes.get(i).toString());
		}

		for (int i = 0; i < listaPacientes.size(); i++){
			System.out.println(listaPacientes.get(i).getDescripcionEnfermedad());
		}

		 */

	}

}
