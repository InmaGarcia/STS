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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
@Entity
@Table
public class Deportista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nombre;
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "deportista_deporte", 
	joinColumns= {@JoinColumn(name="id_deportista")}, 
	inverseJoinColumns = {@JoinColumn(name="id_deporte")})
	private Set<Deporte> deportes;
	
	public Deportista(String nombre, Set<Deporte> deportes) {
		super();
		this.nombre = nombre;
		this.deportes = new HashSet<>();
	}

	public Deportista() {
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

	public Set<Deporte> getDeportes() {
		return deportes;
	}

	public void setDeportes(Set<Deporte> deportes) {
		this.deportes = deportes;
	}

	@Override
	public String toString() {
		return "Deportista [id=" + id + ", nombre=" + nombre + ", deportes=" + deportes + "]";
	}
	
	
	
	
	
	
}
