package Deportista.Servicio;

import java.util.List;

import Deportista.Modelo.Deporte;
import Deportista.Modelo.Deportista;

public interface Servicio {

	void crearDeportista(Deportista deportista);

	void crearDeporte(Deporte deporte);

	List<Deportista> listaDeportistas();

	void agregarDeporte(Deportista deportista, Deporte deporte);

	List<Deporte> listaDeportes();

	Deportista deportistaId(Long id);

	void eliminarDeporteADeportistas(Deportista deportista, Deporte deporte);

	Deporte deporteId(Long id);

	List<Deportista> buscarDeportistaPorDeporte(String nombreDeporte);

}
