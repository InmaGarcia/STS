package com.Tema4ej1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tema4ej1.modelo.Cliente;
import com.Tema4ej1.service.ClienteServiceImp;

@RestController
@RequestMapping("/clientes")
public class ClienteControlador {
	
	@Autowired
	private ClienteServiceImp service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getClientes(){
		List<Cliente> clientes = service.getClientes();
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getCliente(@PathVariable Integer id){
		Cliente c = service.getCliente(id);
		return ResponseEntity.ok(c);
	}
	
	@PostMapping
	public ResponseEntity<Void> insertarCliente(@RequestBody Cliente c){
		service.insertarCliente(c);
		return ResponseEntity.noContent().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> borrarCliente(@PathVariable Integer id){
		service.borrarCliente(id);
		return ResponseEntity.noContent().build();
		
	}

}
