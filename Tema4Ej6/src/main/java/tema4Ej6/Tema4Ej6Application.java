package tema4Ej6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tema4Ej6.Modelo.Cliente;
import tema4Ej6.Modelo.Direccion;
import tema4Ej6.Servicio.Servicio;

@SpringBootApplication
public class Tema4Ej6Application {

	public static void main(String[] args) {
		SpringApplication.run(Tema4Ej6Application.class, args);
	}

	@Autowired
	private Servicio service;

	public void run(String... args) throws Exception {

		// 1

		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Pepe Ruiz");

		Direccion dir1 = new Direccion();
		dir1.setCalle("Sol");
		dir1.setCiudad("Oviedo");
		cliente1.setDireccion(dir1);
		service.crear(cliente1);

		// 2
		Cliente cliente2 = new Cliente();
		cliente2.setNombre("Andrés Ramírez");

		Direccion dir2 = new Direccion();
		dir2.setCalle("Mar");
		dir2.setCiudad("Cadiz");
		cliente2.setDireccion(dir2);
		service.crear(cliente2);

		// 3
		mostrarClientes();

		// 4
		
		System.out.println(service.getCliente(cliente1.getId()));

		// 5

		cliente1.setNombre("Pepe Jose Ruiz");
		cliente1.getDireccion().setCalle("Luna");
		cliente1.getDireccion().setCiudad("Madrid");
		service.crear(cliente1);

		// 6
		mostrarClientes();
		
		//7
		Cliente cliente3 = new Cliente();
		cliente3.setNombre("Andrés Ramírez");

		Direccion dir3 = new Direccion();
		dir3.setCalle("Mar");
		dir3.setCiudad("Cadiz");
		cliente3.setDireccion(dir3);
		service.crear(cliente3);
		
		mostrarClientes();
		//8.
		Direccion d = new Direccion();
		d.setCalle("Estrella");
		d.setCiudad("Málaga");
		service.actualizarDireccion(cliente2.getId(), d);
		
		mostrarClientes();
		
		//9
		service.actualizarSevilla();
		mostrarClientes();
		
		//10
		service.actualizarCiudadNombre("Granada","P");
		mostrarClientes();
		
		//11
		List<Cliente> clSevilla = service.getClientesPorCiudad("Sevilla");
		for (Cliente sevilla : clSevilla) {
			System.out.println(sevilla);
		}
		
		//12
		service.borrar(cliente3.getId());
		
		//13
		mostrarClientes();
		
	}

	private void mostrarClientes() {

		List<Cliente> clientes = service.getClientes();
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}

}
