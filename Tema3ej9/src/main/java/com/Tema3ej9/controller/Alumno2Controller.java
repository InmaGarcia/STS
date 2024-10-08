package com.Tema3ej9.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.ResponseEntity;
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
public class Alumno2Controller {
	
	private List<Alumno> alumnos = new ArrayList<>();

	public Alumno2Controller() {
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
	public ResponseEntity<List<Alumno>> getAlumnos(){
		return ResponseEntity.ok(alumnos);
	}
	
	//Consultar un alumno por su email
	@GetMapping("/{email}")
	public ResponseEntity<Alumno> getEmail(@PathVariable String email) {
		for(Alumno alumno : alumnos) {
			if(alumno.getEmail().equals(email)) {
				return ResponseEntity.ok(alumno);	
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	//Crear un nuevo alumno
	@PostMapping
	public ResponseEntity<Void> crearAlumno(@PathVariable Alumno alumno) {
		alumnos.add(alumno);
		return ResponseEntity.noContent().build();
	}
	
	//Modificar la información de un alumno tanto de manera parcial como total
	@PutMapping
	public ResponseEntity<Void> modificarAlumno(@PathVariable Alumno modif) {
		for(Alumno alumno : alumnos) {
			if(alumno.getId()==modif.getId()) {
				alumno.setCurso(modif.getCurso());
				alumno.setEdad(modif.getEdad());
				alumno.setEmail(modif.getEmail());
				alumno.setNombre(modif.getNombre());
				
				return ResponseEntity.noContent().build();
			}			
		}
		return ResponseEntity.notFound().build();
	}
	
	@PatchMapping
	public ResponseEntity<Void> modificarAtributo(@PathVariable Alumno modif) {
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
				return ResponseEntity.noContent().build();
			}
			
		}
		return ResponseEntity.notFound().build();
	}
	//Eliminar un alumno por su id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> borrarAlumno(@PathVariable int id) {
		Iterator<Alumno> iterador = alumnos.iterator();
		while(iterador.hasNext()) {
			Alumno a =iterador.next();		
			if(a.getId() == id) {
				iterador.remove();
				ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	

}
