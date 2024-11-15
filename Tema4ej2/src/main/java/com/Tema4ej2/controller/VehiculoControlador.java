package com.Tema4ej2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tema4ej2.modelo.Vehiculo;
import com.Tema4ej2.service.VehiculoService;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoControlador {
	
	@Autowired
	private VehiculoService service;
	
	//Consultar la lista de vehículos
	@GetMapping
	public ResponseEntity<List<Vehiculo>> getVehiculos(){
		List<Vehiculo> coches = service.getVehiculos();
		
		if(coches == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(coches);
		}
		
	}
	
	//Consultar Vehículo especifico mediante id
	@GetMapping("/{id}")
	public ResponseEntity<Vehiculo> getVehiculoById(@PathVariable Integer id){
		Vehiculo coche = service.getVehiculoById(id);
		return ResponseEntity.ok(coche);
	}
	
	//Crear Vehículo con los atributos especificados. Devolver el insertado
	@PostMapping
	public ResponseEntity<Vehiculo> crearVehiculo(@RequestBody Vehiculo nuevo){
		Vehiculo insertado = service.crearVehiculo(nuevo);
		if(insertado == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(insertado);
		}
	}

}
