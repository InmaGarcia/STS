package Deportista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Deportista.Modelo.Deporte;
import Deportista.Modelo.Deportista;
import Deportista.Servicio.Servicio;

@SpringBootApplication
public class DeportistaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DeportistaApplication.class, args);
	}

	@Autowired
	Servicio servicio;
	
	@Override
	public void run(String... args) throws Exception {
		
		Deportista deportista1 = new Deportista();
		deportista1.setNombre("Juan Perez");
		
		Deportista deportista2 = new Deportista();
		deportista2.setNombre("Lidia Garcia");
		
		servicio.crearDeportista(deportista1);
		servicio.crearDeportista(deportista2);
		
		Deporte futbol = new Deporte();
		futbol.setNombre("futbol");
		Deporte tenis = new Deporte();
		tenis.setNombre("tenis");
		Deporte baloncesto = new Deporte();
		baloncesto.setNombre("baloncesto");
		
		servicio.crearDeporte(futbol);
		servicio.crearDeporte(tenis);
		servicio.crearDeporte(baloncesto);
		
		listarDeportistas();
		
		servicio.agregarDeporte(deportista1, futbol);
		servicio.agregarDeporte(deportista1, baloncesto);
		servicio.agregarDeporte(deportista2, tenis);
		
		listarDeportistas();
		
		Deporte badminton = new Deporte();
		badminton.setNombre("badminton");
		servicio.crearDeporte(badminton);
		servicio.agregarDeporte(deportista2, badminton);
		
		Deportista d = servicio.deportistaId(deportista2.getId());
		System.out.println(d);
		
		servicio.eliminarDeporteADeportistas(deportista1, futbol);
		
		Deportista d1 = servicio.deportistaId(deportista1.getId());
		System.out.println(d1);
	}

	private void listarDeportistas() {
        List<Deportista> deportistas = servicio.listaDeportistas();
		for(Deportista d : deportistas) {
			System.out.println(d);
		}
	}
	
}
