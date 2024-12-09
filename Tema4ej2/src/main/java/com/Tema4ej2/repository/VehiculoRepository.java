package com.Tema4ej2.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.Tema4ej2.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
public class VehiculoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Vehiculo> getVehiculos(){
		Query<Vehiculo> query = (Query<Vehiculo>) entityManager.createQuery("select v from Vehiculo v", Vehiculo.class);
		List<Vehiculo> lista = query.getResultList();
		return lista;
	}
	
	public Vehiculo getVehiculoById(Integer id) {
		Vehiculo coche = entityManager.find(Vehiculo.class, id);
		return coche;
	}
	
	public Vehiculo crearVehiculo(Vehiculo nuevo) {
		entityManager.persist(nuevo);
		return nuevo;
	}
	
	public List<Vehiculo> consultarVehiculosPorEstado(String estado){
		return entityManager.
	}
	
}
