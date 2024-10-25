package com.Tema3ej14_TipoExamen.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tema3ej14_TipoExamen.modulo.Actor;
import com.Tema3ej14_TipoExamen.modulo.Pelicula;

@RestController
@RequestMapping("/peliculas")
public class PeliculasController {
	
	private List<Pelicula> peliculas = new ArrayList<>();
	
	
	public PeliculasController() {
		List<Actor> actores1 = new ArrayList<>();
		actores1.add(new Actor(1,"Jennifer Lauren","EEUU"));
		actores1.add(new Actor(2,"Mark Damon","Canada"));
		List<Actor> actores2 = new ArrayList<>();
		actores2.add(new Actor(1,"Jennifer Lauren","EEUU"));
		actores2.add(new Actor(3,"Chris Pratt","EEUU"));
		List<Actor> actores3 = new ArrayList<>();
		actores3.add(new Actor(4,"Larisa Milano","Francia"));
		actores3.add(new Actor(3,"Chris Pratt","EEUU"));
		actores3.add(new Actor(5,"Batista","Mexico"));
		List<Actor> actores4 = new ArrayList<>();
		actores4.add(new Actor(6,"Emma Watson","Inglaterra"));
		actores4.add(new Actor(7,"Daniel Radclive","Inglaterra"));
		
		Pelicula p1 = new Pelicula(1,"Los juegos del hambre","Disney",LocalDate.of(2019, 1, 1),90,actores1);
		Pelicula p2 =new Pelicula(2,"Sinsajo","Disney",LocalDate.of(2021, 1, 1),90,actores1);
		Pelicula p3 =new Pelicula(3,"Viaje intelestelar","Marvel",LocalDate.of(2015, 1, 1),82,actores2);
		Pelicula p4 =new Pelicula(4,"Los guardianes de la galaxia","Marvel",LocalDate.of(2020, 1, 1),95,actores3);
		Pelicula p5 =new Pelicula(5,"Harry Potter 1","Disney",LocalDate.of(2001, 1, 1),110,actores4);
		Pelicula p6 =new Pelicula(6,"Harry Potter 2","Disney",LocalDate.of(2002, 1, 1),100,actores4);
		Pelicula p7 =new Pelicula(7,"Harry Potter 3","Disney",LocalDate.of(2004, 1, 1),92,actores4);
		
		peliculas.add(p1);
		peliculas.add(p2);
		peliculas.add(p3);
		peliculas.add(p4);
		peliculas.add(p5);
		peliculas.add(p6);
		peliculas.add(p7);
	}
	
	//Mostrar todas las películas
	@GetMapping
	public ResponseEntity<List<Pelicula>> getPeliculas(){
		return ResponseEntity.ok(peliculas);
	}
	
	//Consultar una película por su título
	@GetMapping("/titulos/{titulo}")
	public ResponseEntity<Pelicula> getPeliculaTitulo(@PathVariable String titulo){
		for(Pelicula pelicula : peliculas) {
			if(pelicula.getTitulo().equalsIgnoreCase(titulo)) {
				return ResponseEntity.ok(pelicula);
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	//Crear una nueva película
	@PostMapping
	public ResponseEntity<Void> crearPelicula(@RequestBody Pelicula nueva){
		peliculas.add(nueva);
		return ResponseEntity.noContent().build();
	}
	
	//Modificar la información de una película de manera parcial y total
	@PutMapping
	public ResponseEntity<Void> modificarPeliculaT(@RequestBody Pelicula modif){
		for(Pelicula pelicula : peliculas) {
			if(pelicula.getId()==modif.getId()) {
				pelicula.setActores(modif.getActores());
				pelicula.setDirector(modif.getDirector());
				pelicula.setDuracion(modif.getDuracion());
				pelicula.setLanzamiento(modif.getLanzamiento());
				pelicula.setTitulo(modif.getTitulo());
				return ResponseEntity.noContent().build();
			}
			
		}
		return ResponseEntity.notFound().build();
	}
	
	@PatchMapping
	public ResponseEntity<Void> modificarPeliculaP(@RequestBody Pelicula modif){
		for(Pelicula pelicula : peliculas) {
			if(pelicula.getId()==modif.getId()) {
				if(modif.getActores()!=null) {
					pelicula.setActores(modif.getActores());
				}
				if(modif.getDirector()!=null) {
					pelicula.setDirector(modif.getDirector());
					
				}
				if(modif.getDuracion()!=null) {
					pelicula.setDuracion(modif.getDuracion());
					
				}
				if(modif.getLanzamiento()!=null) {
					pelicula.setLanzamiento(modif.getLanzamiento());
					
				}
				if(modif.getTitulo()!=null) {
					pelicula.setTitulo(modif.getTitulo());
				}
				return ResponseEntity.noContent().build();
			}
			
		}
		return ResponseEntity.notFound().build();
	}
	
	//Eliminar una película por su id
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<Void> borrarPelicula(@PathVariable int id) {
		Iterator<Pelicula> iterador = peliculas.iterator();
		while(iterador.hasNext()) {
			Pelicula a =iterador.next();		
			if(a.getId() == id) {
				iterador.remove();
				ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	//Obtener todas las películas por un director específico
	@GetMapping("/porDirector/{director}")
	public ResponseEntity<List<Pelicula>> getPeliculaDirector(@PathVariable String director){
		List<Pelicula> porDirector = new ArrayList<>();
		for(Pelicula pelicula : peliculas) {
			if(pelicula.getDirector().equalsIgnoreCase(director)) {
				porDirector.add(pelicula);
				
			}
			
		}
		if(porDirector.isEmpty()) {
		return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(porDirector);
		}
	}
	
	//Obtener todas las películas de los últimos 5 años
	@GetMapping("/recientes")
	public ResponseEntity<List<Pelicula>> getPeliculaAnyo(){
		List<Pelicula> porAnyo = new ArrayList<>();
		for(Pelicula pelicula : peliculas) {
			if(pelicula.getLanzamiento().isAfter(LocalDate.now().minusYears(5))) {
				porAnyo.add(pelicula);
			}
			
		}
		if(porAnyo.isEmpty()) {
			return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(porAnyo);
			}
	}
	
	//Obtener la película con la mayor duración
	@GetMapping("/larga")
	public ResponseEntity<Pelicula> getPeliculaLarga(){
		int larga =0;
		Pelicula masLarga = new Pelicula();
		for(Pelicula pelicula : peliculas) {
			if(pelicula.getDuracion()>larga) {
				larga=pelicula.getDuracion();
				masLarga = pelicula;
			}
		}
		return ResponseEntity.ok(masLarga);
	}
	
	//Obtener un mapa con los directores con más de X películas, donde la clave es el nombre del
	//director y la clave el número de películas
	@GetMapping("/directores/{num}")
	public ResponseEntity<Map<String,Integer>> getDirectores(@PathVariable Integer num){
		Map<String,Integer> conteoPorDirector = new HashMap<>();
		//contar la cantidad
		for(Pelicula pelicula : peliculas) {
			String director = pelicula.getDirector();
			conteoPorDirector.put(director, conteoPorDirector.getOrDefault(pelicula.getDirector(),0)+1);
		}
		
		//filtar por num
		Map<String,Integer> directoresFiltrado = new HashMap<>();
		for(Map.Entry<String,Integer> entry : conteoPorDirector.entrySet()) {
			if(entry.getValue() > num) {
				directoresFiltrado.put(entry.getKey(), entry.getValue());
			}
		}
		if(directoresFiltrado.isEmpty()) {
			return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(directoresFiltrado);
			}
	}
	
	//Obtener la lista de todos los actores sin repetir ninguno. ¿Qué estructura de datos
	//podemos usar?
	@GetMapping("/actores")
	public ResponseEntity<Set<Actor>> getActores(){
		Set<Actor> todos= new HashSet<>();
		for(Pelicula pelicula : peliculas) {
			for(Actor actor : pelicula.getActores()) {
				todos.add(actor);
			}
			
		}
		if(todos.isEmpty()) {
			return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(todos);
			}
	}
	
	//ObtenerPeliculasPorActor. Este método obtiene una lista de todas las películas en las que
	//ha participado un actor específico, dado su nombre.
	@GetMapping("/porActor/{a}")
	public ResponseEntity<List<Pelicula>> obtenerPeliculasPorActor(@PathVariable String a){
		List<Pelicula> porActores = new ArrayList<>();
		for(Pelicula pelicula : peliculas) {
			for(Actor actor : pelicula.getActores()) {		
				if(actor.getNombre().equalsIgnoreCase(a)) {
					porActores.add(pelicula);
					break; //una vez que encuentra el actor pasa a la siguiente pelicula
				}
			}
		}
		if(porActores.isEmpty()) {
			return ResponseEntity.notFound().build();			
		}
		else {
			return ResponseEntity.ok(porActores);
		}
	}
	
	//ObtenerActoresPorNacionalidad. Este método obtiene todos los actores que tienen una
	//nacionalidad específica dada por parámetro
	@GetMapping("/actores/nacionalidad/{n}")
	public ResponseEntity<List<Actor>> obtenerActoresPorNacionalidad(@PathVariable String n){
		List<Actor> actorNacionalidad = new ArrayList<>();
		for(Pelicula pelicula : peliculas) {
			for(Actor actor : pelicula.getActores()) {
				if(actor.getNacionalidad().equalsIgnoreCase(n)) {
					actorNacionalidad.add(actor);
					
				}
			}
		}
		if(actorNacionalidad.isEmpty()) {
			return ResponseEntity.notFound().build();			
		}
		else {
			return ResponseEntity.ok(actorNacionalidad);
		}
	}

}
