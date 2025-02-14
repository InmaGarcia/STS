package Tema4Ej10.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Empleado {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	 	@Column
	    private String nombre;
	 	@Column
	    private String puesto;
	 	@Column
	    private String email;

	    @ManyToOne
	    @JoinColumn(name = "oficina_id")
	    private Oficina oficina;

		public Empleado(Integer id, String nombre, String puesto, String email, Oficina oficina) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.puesto = puesto;
			this.email = email;
			this.oficina = oficina;
		}

		public Empleado() {
			super();
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

		public String getPuesto() {
			return puesto;
		}

		public void setPuesto(String puesto) {
			this.puesto = puesto;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Oficina getOficina() {
			return oficina;
		}

		public void setOficina(Oficina oficina) {
			this.oficina = oficina;
		}

		@Override
		public String toString() {
			return "Empleado [id=" + id + ", nombre=" + nombre + ", puesto=" + puesto + ", email=" + email
					+ ", oficina=" + oficina + "]";
		}
	    
	    

}
