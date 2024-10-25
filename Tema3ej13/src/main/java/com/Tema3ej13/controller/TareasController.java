package com.Tema3ej13.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tema3ej13.modelo.Tarea;


@RestController
@RequestMapping("/tareas")
public class TareasController {
	
	private List<Tarea> tareas = new ArrayList<>();
	
	public TareasController() {
		Tarea tarea1 = new Tarea(1,"javascript","ejercicios de ventanas",LocalDate.of(2024, 12, 1));
		Tarea tarea2 = new Tarea(2,"ingles","carta de presentacion para puesto laboral",LocalDate.of(2024, 10, 29));
		Tarea tarea3 = new Tarea(3,"php","programa Cerveceria",LocalDate.of(2024, 11, 18 ));
		Tarea tarea4 = new Tarea(4,"ingles","correo informal",LocalDate.of(2024, 10, 24 ));
	}
	
	//Mostrar todas las tareas
		@GetMapping
		public ResponseEntity<List<Tarea>> getTareas(){
			return ResponseEntity.ok(tareas);
		}
		
		//Consultar una tarea por ID
		@GetMapping("/{id}")
		public ResponseEntity<Tarea> getPeliculaTitulo(@PathVariable Integer id){
			for(Tarea tarea : tareas) {
				if(tarea.getId() == id) {
					return ResponseEntity.ok(tarea);
				}
			}
			return ResponseEntity.notFound().build();
		}
		
		//Crear una nueva tarea
		@PostMapping
		public ResponseEntity<Void> crearTarea(@RequestBody Tarea nueva){
			tareas.add(nueva);
			return ResponseEntity.noContent().build();
		}
		
		//Actualizar una tarea
		@PutMapping(" /tareas/{id}")
		public ResponseEntity<Void> modificarTareaT(@RequestBody Tarea modif){
			for(Tarea tarea : tareas) {
				if(tarea.getId()==modif.getId()) {
					tarea.setDescripcion(modif.getDescripcion());
					tarea.setEstado(modif.getEstado());
					tarea.setTitulo(modif.getTitulo());
					tarea.setVencimiento(modif.getVencimiento());
				}
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.notFound().build();
		}
		
		@PatchMapping
		public ResponseEntity<Void> modificarPeliculaP(@RequestBody Tarea modif){
			for(Tarea tarea : tareas) {
				if(tarea.getId()==modif.getId()) {
					if(modif.getDescripcion()!=null) {
						tarea.setDescripcion(modif.getDescripcion());
					}
					if(modif.getEstado()!=null) {
						tarea.setEstado(modif.getEstado());
						
					}
					if(modif.getTitulo()!=null) {
						tarea.setTitulo(modif.getTitulo());
						
					}
					if(modif.getVencimiento()!=null) {
						tarea.setVencimiento(modif.getVencimiento());
				}
				return ResponseEntity.noContent().build();
			}
			
		}
			return ResponseEntity.notFound().build();
		
}
}
