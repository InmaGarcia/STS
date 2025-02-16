package Tema4Ej10;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Tema4Ej10.Modelo.Empleado;
import Tema4Ej10.Modelo.Oficina;
import Tema4Ej10.Servicio.EmpleadoServicioImp;
import Tema4Ej10.Servicio.OficinaServicioImp;

@SpringBootApplication
public class Tema4Ej10Application implements CommandLineRunner{
	
	private EmpleadoServicioImp empServicio;
	private OficinaServicioImp ofiServicio;

	public static void main(String[] args) {
		SpringApplication.run(Tema4Ej10Application.class, args);
	}
	 @Override
	    public void run(String... args) throws Exception {
	        // Crear y probar empleados y oficinas
	        Oficina oficina1 = new Oficina();
	        oficina1.setUbicacion("Sevilla");
	        oficina1.setTelefono("123456789");
	        ofiServicio.crearOficina(oficina1);

	        Empleado empleado1 = new Empleado();
	        empleado1.setNombre("Inma");
	        empleado1.setPuesto("Desarrollador");
	        empleado1.setEmail("inma@ceu.com");
	        empleado1.setOficina(oficina1);

	        empServicio.crearEmpleado(empleado1);

	        empServicio.listarEmpleados();
	        ofiServicio.listarOficinas();
	    }
}
