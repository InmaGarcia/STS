package com.Tema4ej10.Repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.Tema4ej10.Modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class EmpleadoRepoImp implements EmpleadoRepo{

	@PersistenceContext
    private EntityManager entityManager;

	 @Override
    public Empleado save(Empleado empleado) {
        if (empleado.getId() == null) {
            entityManager.persist(empleado);
            return empleado;
        } else {
            return entityManager.merge(empleado);
        }
    }

	 @Override
    public Empleado findById(Integer id) {
        return entityManager.find(Empleado.class, id);
    }

	 @Override
    public List<Empleado> findAll() {
        return entityManager.createQuery("FROM Empleado", Empleado.class).getResultList();
    }

	 @Override
    public List<Empleado> findByPuesto(String puesto) {
        return entityManager.createQuery("FROM Empleado e WHERE e.puesto = :puesto", Empleado.class)
                .setParameter("puesto", puesto)
                .getResultList();
    }

	

	 @Override
    public void deleteById(Integer id) {
        Empleado empleado = entityManager.find(Empleado.class, id);
        if (empleado != null) {
            entityManager.remove(empleado);
        }
    }
    
	 @Override
	 public long countEmpleadosByOficinaId(Integer oficinaId) {
        String jpql = "SELECT COUNT(e.id) FROM Empleado e WHERE e.oficina.id = :oficinaId";
        return entityManager.createQuery(jpql, Long.class)
                            .setParameter("oficinaId", oficinaId)
                            .getSingleResult();
    }


}
