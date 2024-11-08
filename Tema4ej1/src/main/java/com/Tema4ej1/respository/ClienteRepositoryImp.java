package com.Tema4ej1.respository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.Tema4ej1.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ClienteRepositoryImp {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Cliente> getClientes(){
		Query<Cliente> query = (Query<Cliente>) entityManager.createQuery("select c from Cliente c", Cliente.class);
		List<Cliente> lista = query.getResultList();
		return lista;
	}
	
	public Cliente getCliente(Integer id) {
		
		Cliente cliente =entityManager.find(Cliente.class,id);
		return cliente;
	}
	
	public void insertarCliente(Cliente c) {
		entityManager.persist(c);
		System.out.println(c);
	}
	
	public void borrarCliente(Integer id) {
		Cliente c = getCliente(id);
		entityManager.remove(c);
	}
}
