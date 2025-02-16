package Deportista.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Deportista.Modelo.Deporte;
import Deportista.Modelo.Deportista;
import Deportista.Repositorio.Repositorio;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServicioImp implements Servicio{
	
	@Autowired
	private Repositorio repo;
	
	@Override
	public void crearDeportista(Deportista deportista) {
		repo.crearDeportista(deportista);
	}
	
	@Override
	public void crearDeporte(Deporte deporte) {
		repo.crearDeporte(deporte);
	}
	
	@Override
	public List<Deportista> listaDeportistas(){
		return repo.listaDeportistas();
	}
	
	@Override
	public List<Deporte> listaDeportes(){
		return repo.listaDeportes();
	}
	
	@Override
	public void agregarDeporte(Deportista deportista, Deporte deporte) {
		Deportista d = repo.deportistaId(deportista.getId());
		Deporte depor = repo.deporteId(deporte.getId());
		
		if(d !=null && depor != null) {
		d.getDeportes().add(depor);
		depor.getDeportistas().add(d);
		repo.crearDeportista(d);
		}
	}
	@Override
	public Deportista deportistaId(Long id) {
		return repo.deportistaId(id);
	}
	
	@Override
	public Deporte deporteId(Long id) {
		return repo.deporteId(id);
	}
	
	@Override
	public void eliminarDeporteADeportistas(Deportista deportista, Deporte deporte) {
		Deportista d = repo.deportistaId(deportista.getId());
		Deporte depor = repo.deporteId(deporte.getId());
		
		if(d !=null && depor != null) {
			d.getDeportes().remove(depor);
			depor.getDeportistas().remove(d);
			repo.crearDeportista(d);
			}
	}
	
	@Override
	public List<Deportista> buscarDeportistaPorDeporte(String nombreDeporte){
		return repo.buscarDeportistaPorDeporte(nombreDeporte);
	}
}
