package tema4Ej6.Modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String nombre;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="direccion_id")
	private Integer direccionId;
	
	
	public Cliente(Integer id, String nombre, Integer direccionId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccionId = direccionId;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getDireccionId() {
		return direccionId;
	}


	public void setDireccionId(Integer direccionId) {
		this.direccionId = direccionId;
	}
	
	
	
	
}
