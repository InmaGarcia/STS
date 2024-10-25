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
import com.Tema3ej9.modelo.Direccion;


@RestController
@RequestMapping("/alumnos")
public class Alumno2Controller {
	
	private List<Alumno> alumnos = new ArrayList<>();
	Direccion d1= new Direccion("amapola","41950","Sevilla");
	Direccion d2= new Direccion("margarita","41940","Tomares");
	Direccion d3= new Direccion("jazmin","41920","Sevilla");
	Direccion d4= new Direccion("lavanda","21006","Huelva");

	public Alumno2Controller() {
		Alumno a1 = new Alumno(01,"Inma","inma@g.com",33,"2DAW",d1);
		alumnos.add(a1);
		Alumno a2 = new Alumno(02,"Estefania","estefy@g.com",30,"2DAW",d2);
		alumnos.add(a2);
		Alumno a3 = new Alumno(03,"Ana","annita@g.com",21,"2DAW",d3);
		alumnos.add(a3);
		Alumno a4 = new Alumno(04,"Juan","juancho@g.com",18,"2DAM",d4);
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
				alumno.setDireccion(modif.getDireccion());
				
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
				if(modif.getDireccion()!=null) {
					alumno.setDireccion(modif.getDireccion());
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
	
	@GetMapping("/direcciones")
	public ResponseEntity<List<Direccion>> getDirecciones(){
		List<Direccion> direcciones = new ArrayList<>();
		for(Alumno alumno : alumnos) {	
			direcciones.add(alumno.getDireccion());			
		}
		return ResponseEntity.ok(direcciones);
	}
	
	@GetMapping("/direcciones/{cp}")
	public ResponseEntity<List<Direccion>> obtenerDireccionesPorCodigoPostal(@PathVariable String cp){
		List<Direccion> cps = new ArrayList<>();
		for(Alumno alumno : alumnos) {
			if(alumno.getDireccion().getCp().equalsIgnoreCase(cp)) {
				cps.add(alumno.getDireccion());
			}					
		}
		if(cps.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(cps);
		}		
	}
	
	@GetMapping("/cantidad/{ciudad}")
	public ResponseEntity<String> contarAlumnosPorCiudad(@PathVariable String ciudad){
		Integer suma=0;
		for(Alumno alumno : alumnos) {
			if(alumno.getDireccion().getCiudad().equalsIgnoreCase(ciudad)) {
				suma++;
			}
		}
		if(suma ==0) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok("En "+ciudad+" hay "+suma+" alumnos");
		}
	}

}
