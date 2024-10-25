package com.Tema3ej12.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tema3ej12.modelo.Libro;
import com.Tema3ej9.modelo.Alumno;

@RestController
@RequestMapping("/libros")
public class LibrosController {
	
	
	private List<Libro> libros = new ArrayList<>();	
		
	public LibrosController() {	
		List<String> generos1 = new ArrayList<>();
		generos1.add("Aventura");
		generos1.add("Fantasia");
		List<String> generos2 = new ArrayList<>();
		generos2.add("Fantasia");
		generos2.add("Infantil");
		List<String> generos3 = new ArrayList<>();
		generos3.add("Romance");
		generos3.add("Novela");
		List<String> generos4 = new ArrayList<>();		
		generos4.add("Romance");
		generos4.add("Juvenil");
		Libro libro1 = new Libro("1001","El señor de los anillos","JR Tolkien","Minotauro","16283", 1970,generos1);
		Libro libro2 = new Libro("1022","Harry Poter y la piedra filosofal","JK Rowling","Salamandra","91637", 2000,generos2);
		Libro libro3 = new Libro("1023","Harry Poter y la camara de los secretos","JK Rowling","Salamandra","91638", 2001,generos2);
		Libro libro4 = new Libro("1333","Pideme lo que quieras","Megan Maxwell","Planeta de Libros","37184", 2010,generos3);
		Libro libro5 = new Libro("4444","Rubi","Kerstin Giers","Montena","00924", 2019,generos4);
		Libro libro6 = new Libro("4445","Zafiro","Kerstin Giers","Montena","00925", 2020,generos4);
		Libro libro7 = new Libro("4446","Esmeralda","Kerstin Giers","Montena","00926", 2021,generos4);
		libros.add(libro1);
		libros.add(libro2);
		libros.add(libro3);
		libros.add(libro4);
		libros.add(libro5);
		libros.add(libro6);
		libros.add(libro7);
	}
	

	//Mostrar todos los libros
	@GetMapping
	public ResponseEntity<List<Libro>> getLibros(){
		return ResponseEntity.ok(libros);
	}
	
	//Consultar un libro por su título
	@GetMapping("/{titulo}")
	public ResponseEntity<Libro> getLibrosTitulo(@PathVariable String titulo){
		for(Libro libro : libros) {
			if(libro.getTitulo().equalsIgnoreCase(titulo)) {
				return ResponseEntity.ok(libro);
			}
		
		}
		return ResponseEntity.notFound().build();
	}
	
	//Crear un nuevo libro
	@PostMapping
	public ResponseEntity<Void> crearLibro(@PathVariable Libro nuevo){
		libros.add(nuevo);
		return ResponseEntity.noContent().build();
	}
	
	//Modificar la información de un libro tanto de manera parcial como total
	
	@PutMapping
	public ResponseEntity<Libro> modificarLibroTotal(@PathVariable Libro modif){
		for(Libro libro : libros) {
			if(libro.getId().equalsIgnoreCase(modif.getId())) {
				libro.setAnyoPublicacion(modif.getAnyoPublicacion());
				libro.setAutor(modif.getAutor());
				libro.setEditorial(modif.getEditorial());
				libro.setIsbn(modif.getIsbn());
				libro.setTitulo(modif.getTitulo());
				libro.setGeneros(modif.getGeneros());
				return ResponseEntity.ok(modif);
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@PatchMapping
	public ResponseEntity<Libro> modificarLibroParcial(@PathVariable Libro modif){
		for(Libro libro : libros) {
			if(libro.getId().equalsIgnoreCase(modif.getId())) {
				if(modif.getAnyoPublicacion()!=null) {
					libro.setAnyoPublicacion(modif.getAnyoPublicacion());
				}
				if(modif.getAutor()!=null) {
					libro.setAutor(modif.getAutor());
				}
				if(modif.getEditorial()!=null) {
					libro.setEditorial(modif.getEditorial());
				}
				if(modif.getIsbn()!=null) {
					libro.setIsbn(modif.getIsbn());
				}
				if(modif.getTitulo()!=null) {
					libro.setTitulo(modif.getTitulo());
				}
				if(modif.getGeneros()!=null) {
					libro.setGeneros(modif.getGeneros());
				}
				return ResponseEntity.noContent().build();
			}
			
		}
		return ResponseEntity.notFound().build();
	}
	
	//Eliminar un libro por su ID

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> borrarLibro(@PathVariable String id) {
		Iterator<Libro> iterador = libros.iterator();
		while(iterador.hasNext()) {
			Libro a =iterador.next();		
			if(a.getId() == id) {
				iterador.remove();
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	//ObtenerNovelas: Devuelve una lista de los libros cuyo genero sea novela.
	
	@GetMapping("/novela")
	public ResponseEntity<List<Libro>> obtenerNovelas(){
		List<Libro> novelas = new ArrayList<>();
		for(Libro libro : libros) {
				if(libro.getGeneros().contains("novela")) {
					novelas.add(libro);
				}
		}
		if(novelas.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		else {
			return ResponseEntity.ok(novelas);
		}
		
	}
	
	//ObtenerPorGenero: Dado un atributo género que se pasa por URL, devolver el listado de
	//libros que sean de dicho género
	
	@GetMapping("/{g}")
	public ResponseEntity<List<Libro>> obtenerPorGenero(@PathVariable String g){
		List<Libro> agrupar = new ArrayList<>();
		for(Libro libro : libros) {
			if(libro.getGeneros().contains(g)) {
				agrupar.add(libro);
			}
		}
		if(agrupar.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		else {
			return ResponseEntity.ok(agrupar);
		}
	}
	
	//ObtenerAutoresConMasDeXLibros: devuelve un mapa de <String,Integer>, donde la clave
	//es el autor, y el valor, el numero de libros que ha escrito a partir del atributo numLibro que
	//se pasará por la URL.
	
	@GetMapping("/numLibros")
	public ResponseEntity<Map<String,Integer>> obtenerAutoresConMasDeXLibros(@PathVariable Integer numLibros){
		Map<String,Integer> cantidadLibros = new HashMap<>();
		for(Libro libro : libros) {
			
			
		}
		
	}
}
