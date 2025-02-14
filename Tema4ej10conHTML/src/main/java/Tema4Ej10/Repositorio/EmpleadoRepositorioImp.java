package Tema4Ej10.Repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import Tema4Ej10.Modelo.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmpleadoRepositorioImp implements EmpleadoRepositorio{

	@PersistenceContext
	private EntityManager puente;
	
	
	    @Override
	    public void save(Empleado empleado) {
	        if (empleado.getId() == null) {
	        	puente.persist(empleado);
	        } else {
	        	puente.merge(empleado);
	        }
	    }

	    @Override
	    public Empleado findById(Integer id) {
	        return puente.find(Empleado.class, id);
	    }

	    @Override
	    public List<Empleado> findAll() {
	        return puente.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
	    }

	    @Override
	    public void deleteById(Integer id) {
	        Empleado empleado = findById(id);
	        if (empleado != null) {
	        	puente.remove(empleado);
	        }
	    }

	    @Override
	    public List<Empleado> findByPuesto(String puesto) {
	        return puente.createQuery("SELECT e FROM Empleado e WHERE e.puesto = :puesto", Empleado.class)
	                .setParameter("puesto", puesto)
	                .getResultList();
	    }
	
}
