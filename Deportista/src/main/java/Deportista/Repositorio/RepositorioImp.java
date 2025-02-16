package Deportista.Repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import Deportista.Modelo.Deporte;
import Deportista.Modelo.Deportista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RepositorioImp implements Repositorio {

	@PersistenceContext
	private EntityManager puente;

	@Override
	public void crearDeportista(Deportista deportista) {
		if (deportista.getId() == null) {
			puente.persist(deportista);
		} else {
			puente.merge(deportista);
		}
	}

	@Override
	public void crearDeporte(Deporte deporte) {
		if (deporte.getId() == null) {
			puente.persist(deporte);
		} else {
			puente.merge(deporte);
		}
	}

	@Override
	public List<Deportista> listaDeportistas() {
		return puente.createQuery("FROM Deportista d", Deportista.class).getResultList();
	}
	
	@Override
	public List<Deporte> listaDeportes() {
		return puente.createQuery("FROM Deporte d", Deporte.class).getResultList();
	}
	
	
	@Override
	public Deportista deportistaId(Long id) {
		return puente.find(Deportista.class, id);
	}
	
	@Override
	public Deporte deporteId(Long id) {
		return puente.find(Deporte.class, id);
	}
	
	@Override
	public List<Deportista> buscarDeportistaPorDeporte(String nombreDeporte){
		String sql="SELECT d FROM Deportista d JOIN d.deportes dep WHERE dep.nombre = :nombreDeporte";
		 return puente.createQuery(sql, Deportista.class).setParameter("nombreDeporte", "%"+nombreDeporte+"%").getResultList();
	}
}
