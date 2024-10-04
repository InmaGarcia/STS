package com.Tema3ej9.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tema3ej9.modelo.Alumno;


@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
	
	private List<Alumno> alumnos = new ArrayList<>();

	public AlumnoController() {
		Alumno a1 = new Alumno(01,"Inma","inma@g.com",33,"2DAW");
		alumnos.add(a1);
		Alumno a2 = new Alumno(02,"Estefania","estefy@g.com",30,"2DAW");
		alumnos.add(a2);
		Alumno a3 = new Alumno(03,"Ana","annita@g.com",21,"2DAW");
		alumnos.add(a3);
		Alumno a4 = new Alumno(04,"Juan","juancho@g.com",18,"2DAM");
		alumnos.add(a4);
	}
	
	//Mostrar todos los alumnos
	@GetMapping
	public List<Alumno> getAlumnos(){
		return alumnos;
	}
	
	//Consultar un alumno por su email
	@GetMapping("/{email}")
	public Alumno getEmail(@PathVariable String email) {
		for(Alumno alumno : alumnos) {
			if(alumno.getEmail().equals(email)) {
				return alumno;	
			}
		}
		return null;
	}
	
	//Crear un nuevo alumno
	@PostMapping
	public Alumno crearAlumno(@PathVariable Alumno alumno) {
		alumnos.add(alumno);
		return alumno;
	}
	
	//Modificar la información de un alumno tanto de manera parcial como total
	@PutMapping
	public Alumno modificarAlumno(@PathVariable Alumno modif) {
		for(Alumno alumno : alumnos) {
			if(alumno.getId()==modif.getId()) {
				return alumno;
			}			
		}
		return null;
	}
	
	@PatchMapping
	public Alumno modificarAtributo(@PathVariable Alumno modif) {
		for(Alumno alumno : alumnos) {
			if(alumno.getId()==modif.getId()) {
				if(modif.getCurso()!=null) {
					alumno.setCurso(modif.getCurso());
				}
				if(modif.getEdad()!=null) {
					alumno.setEdad(modif.getEdad());
				}
				if(modif.getEmail()!=null) {
					alumno.setEmail(modif.getEmail());
				}
				if(modif.getNombre()!=null) {
					alumno.setNombre(modif.getNombre());
				}
			}
			
		}
		return null;
	}
	//Eliminar un alumno por su id
	@DeleteMapping("/{id}")
	public Alumno borrarAlumno(@PathVariable int id) {
		Iterator<Alumno> iterador = alumnos.iterator();
		while(iterador.hasNext()) {
			Alumno a =iterador.next();		
			if(a.getId() == id) {
				iterador.remove();
				return a;
			}
		}
		return null;
	}
	
	

}
