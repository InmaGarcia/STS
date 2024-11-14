package com.Tema4ej2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tema4ej2.modelo.Producto;
import com.Tema4ej2.repository.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository repo;
	
	public List<Producto> getProductos(){
		return repo.getProductos();
	}
	
	public Producto getProducto(Integer id) {
		return repo.getProducto(id);
	}
	
	@Transactional 
	public Producto crearProducto(Producto p) {
		return repo.crearProducto(p);
	}
	
	@Transactional 
	public Producto actualizar(Producto p) {
		return repo.actualizar(p);
	}
	
	@Transactional 
	public Boolean eliminar(Integer id) {
		return repo.eliminar(id);
	}
	
	public List<Producto> getProductosNombre(String nombre){
		return repo.getProductosNombre(nombre);
	}
	
	public List<Producto> getProductoPrecio(Float precio1, Float precio2){
		return repo.getProductoPrecio(precio1, precio2);
	}
	
	@Transactional 
	public List<Producto> insertaLista(List<Producto> productos){
		return repo.insertaLista(productos);
	}
	
	
}
