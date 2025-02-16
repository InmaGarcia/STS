package Deportista.Modelo;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Deporte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nombre;
	@ManyToMany(mappedBy = "deportes",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Deportista> deportistas;
	
	public Deporte(String nombre, Set<Deportista> deportistas) {
		super();
		this.nombre = nombre;
		this.deportistas = new HashSet<>();
	}

	public Deporte() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Deportista> getDeportistas() {
		return deportistas;
	}

	public void setDeportistas(Set<Deportista> deportistas) {
		this.deportistas = deportistas;
	}

	@Override
	public String toString() {
		return "Deporte [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
	

}
