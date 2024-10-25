package com.Tema3ej12.modelo;

import java.util.ArrayList;
import java.util.List;

public class Libro {
	private String id;
	private String titulo;
	private String autor;
	private String editorial;
	private String isbn;
	private Integer anyoPublicacion;
	private List<String> generos;
	
	public Libro() {
		this.generos = new ArrayList<>();
	}
	public Libro(String id, String titulo, String autor, String editorial, String isbn, Integer anyoPublicacion,
			List<String> generos) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.isbn = isbn;
		this.anyoPublicacion = anyoPublicacion;
		this.generos = generos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getAnyoPublicacion() {
		return anyoPublicacion;
	}

	public void setAnyoPublicacion(Integer anyoPublicacion) {
		this.anyoPublicacion = anyoPublicacion;
	}

	public List<String> getGeneros() {
		return generos;
	}

	public void setGeneros(List<String> generos) {
		this.generos = generos;
	}
	
	
	

}
