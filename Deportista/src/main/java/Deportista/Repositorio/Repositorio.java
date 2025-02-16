package Deportista.Repositorio;

import java.util.List;

import Deportista.Modelo.Deporte;
import Deportista.Modelo.Deportista;

public interface Repositorio {

    void crearDeportista(Deportista deportista);

	void crearDeporte(Deporte deporte);

	List<Deportista> listaDeportistas();

	Deportista deportistaId(Long id);

	Deporte deporteId(Long id);

	List<Deporte> listaDeportes();

	List<Deportista> buscarDeportistaPorDeporte(String nombreDeporte);
}
