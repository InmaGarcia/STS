package com.Tema4ej2.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;



import com.Tema4ej2.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ProductoRepository {

	@PersistenceContext
	private EntityManager puente;
	
	public List<Producto> getProductos(){
		Query<Producto> query = (Query<Producto>) puente.createQuery("select p from Producto p", Producto.class);
		List<Producto> lista = query.getResultList();
		return lista;
	}
	
	public Producto getProducto(Integer id) {
		Producto p = puente.find(Producto.class, id);
		return p;
	}
	
	public Producto crearProducto(Producto p) {
		puente.persist(p);
		return p;
	}
	
	public Producto actualizar(Producto p) {
		puente.merge(p);
		return p;
	}
	
	public Boolean eliminar(Integer id) {
		Producto p = getProducto(id);
		if(p != null) {
		puente.remove(p);
		return true;
		}else {
			return false;
		}
		
	}
	
	public List<Producto> getProductosNombre(String nombre){
		String jpql = "SELECT p FROM Producto p WHERE p.nombre LIKE :nombre";
		Query<Producto> query = (Query<Producto>) puente.createQuery(jpql, Producto.class);
		
		query.setParameter("nombre","%"+nombre+"%");
		return query.getResultList();
	}
	
	public List<Producto> getProductoPrecio(Float precio1, Float precio2){
		String jpql = "SELECT p FROM Producto p WHERE p.precio BETWEEN precio1 AND precio2";
		Query<Producto> query = (Query<Producto>) puente.createQuery(jpql, Producto.class);
		
		query.setParameter("precio1",precio1);
		query.setParameter("precio2",precio2);
		return query.getResultList();
	}
	
	public List<Producto> insertaLista(List<Producto> productos){
		for(Producto p : productos) {
			crearProducto(p);
		}
		return productos;
	}
}
