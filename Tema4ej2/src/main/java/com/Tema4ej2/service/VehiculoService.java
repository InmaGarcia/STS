package com.Tema4ej2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tema4ej2.modelo.Vehiculo;
import com.Tema4ej2.repository.VehiculoRepository;

import jakarta.transaction.Transactional;

@Service
public class VehiculoService {
	
	@Autowired
	private VehiculoRepository repo;
	
	public List<Vehiculo> getVehiculos(){
		List<Vehiculo> coches = repo.getVehiculos();
		return coches;
	}
	
	public Vehiculo getVehiculoById(Integer id) {
		Vehiculo coche = repo.getVehiculoById(id);
		return coche;
		
	}
	
	@Transactional
	public Vehiculo crearVehiculo(Vehiculo nuevo) {
		Vehiculo creado = repo.crearVehiculo(nuevo);
		return creado;
	}

}
