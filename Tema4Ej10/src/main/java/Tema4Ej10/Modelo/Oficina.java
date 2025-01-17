package Tema4Ej10.Modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Oficina {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	 	@Column
	    private String ubicacion;
	 	@Column
	    private String telefono;

	    @OneToMany(mappedBy = "oficina")
	    private List<Empleado> empleados;

		public Oficina(Integer id, String ubicacion, String telefono, List<Empleado> empleados) {
			super();
			this.id = id;
			this.ubicacion = ubicacion;
			this.telefono = telefono;
			this.empleados = new ArrayList<>();
		}

		
		public Oficina() {
			super();
		}


		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUbicacion() {
			return ubicacion;
		}

		public void setUbicacion(String ubicacion) {
			this.ubicacion = ubicacion;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public List<Empleado> getEmpleados() {
			return empleados;
		}

		public void setEmpleados(List<Empleado> empleados) {
			this.empleados = empleados;
		}

		@Override
		public String toString() {
			return "Oficina [id=" + id + ", ubicacion=" + ubicacion + ", telefono=" + telefono + ", empleados="
					+ empleados + "]";
		}
	    
	    
}
