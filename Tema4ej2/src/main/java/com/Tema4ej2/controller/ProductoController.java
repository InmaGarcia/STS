package com.Tema4ej2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tema4ej2.modelo.Producto;
import com.Tema4ej2.service.ProductoService;

@RestController
@RequestMapping("/product")
public class ProductoController {

	@Autowired
	private ProductoService service;
	
	//Leer todos
	@GetMapping
	public ResponseEntity<List<Producto>> getProductos(){
		List<Producto> productos = service.getProductos();
		return ResponseEntity.ok(productos);
	}
	
	//Leer por id
	@GetMapping("/{id}")
	public ResponseEntity<Producto> getProducto(@PathVariable Integer id){
		Producto p = service.getProducto(id);
		if(p == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(p);
		}
	}
	
	//Crear
	@PostMapping
	public ResponseEntity<Producto> crearProducto(@RequestBody Producto p){
		Producto nuevo = service.crearProducto(p);
			return ResponseEntity.noContent().build();
		
	}
	
	//actualizar total
	@PutMapping("/{id}")
	public ResponseEntity<Producto> actualizar(@PathVariable Integer id, @RequestBody Producto p){
		p.setId(id);
		Producto actualizado = service.actualizar(p);
		
		if(actualizado == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(actualizado);
		}		
	}
	
	//actualizar parcial
	@PatchMapping("/{id}")
	public ResponseEntity<Producto> actualizarParcial(@PathVariable Integer id, @RequestBody Producto p){
		Producto producto = service.getProducto(id);
		if(producto == null) {
			return ResponseEntity.notFound().build();
		}
		if(p.getNombre()!=null) {
			producto.setNombre(p.getNombre());
		}
		if(p.getPrecio()!=null) {
			producto.setPrecio(p.getPrecio());
		}
		
		Producto actualizado = service.actualizar(producto);
		return ResponseEntity.ok(actualizado);
	}
	
	//eliminar por id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		if(service.eliminar(id)) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//encontrar productos por nombre. Una lista con todos los productos
	@GetMapping("/{nombre}")
	public ResponseEntity<List<Producto>> getProductosNombre(@PathVariable String nombre){
		List<Producto> lista = service.getProductosNombre(nombre);
		if(lista.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	//Encontrar productos por rango de precios: Dado dos precios
	@GetMapping("/precio1/precio2")
	public ResponseEntity<List<Producto>> getProductoPrecio(@PathVariable Float precio1, Float precio2){
		List<Producto> lista = service.getProductoPrecio(precio1, precio2);
		if(lista.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	/*Insertar una lista de productos: Dada una lista de productos insertarlos en base de datos.
		Asegurándote de que los productos nuevos se inserten y los productos existentes se
		actualicen.*/

	@PostMapping
	public ResponseEntity<List<Producto>> insertaLista(@RequestBody List<Producto> productos){
		List<Producto> lista = service.insertaLista(productos);
		List<Producto> actual = service.getProductos();
		
		if(lista.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		if(lista.size() < actual.size()) {			
			return ResponseEntity.ok(actual);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
