package com.Tema3ej2.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Tema3ej2.modelo.Cliente;

@RestController
public class Username {
	/*
	private List<Cliente> clientes = new ArrayList<>();
	
	public Username() {
	Cliente c1 = new Cliente(01,"Inma","Inmy","IG01");
	clientes.add(c1);
	Cliente c2 = new Cliente(02,"Estefania","Fanion","EO02");
	clientes.add(c2);
	Cliente c3 = new Cliente(03,"Ana","Anuska","AG03");
	clientes.add(c3);
	Cliente c4 = new Cliente(04,"Jose","Chelin","JP04");
	clientes.add(c4);
	}
	
	@GetMapping("/clientes")
	public List<Cliente> getClientes(){
		return clientes;
	}
	
	@GetMapping("/clientes/{username}")
	public Cliente getUsername(@PathVariable String username) {
		for(Cliente cliente : clientes) {
			if(cliente.getUsername().equals(username)) {
				return cliente;
			}
		}
		return null;		
	}
	
	@PostMapping("/clientes")
	public Cliente postClientes(@RequestBody Cliente cliente) {
		clientes.add(cliente);
		return cliente;
	}

	@PutMapping("/clientes")
	public Cliente putClientes(@RequestBody Cliente modif) {
		for(Cliente cliente : clientes) {
			if(cliente.getId() == modif.getId()) {
				cliente.setNombre(modif.getNombre());
				cliente.setPassword(modif.getPassword());
				cliente.setUsername(modif.getUsername());
			}
		}
		return modif;
	}
	
	@DeleteMapping("/clientes/{id}")
	public Cliente deleteCliente(@PathVariable int id) {
		
		Iterator<Cliente> iterador = clientes.iterator();
		while(iterador.hasNext()) {
			Cliente cliente =iterador.next();		
			if(cliente.getId() == id) {
				iterador.remove();
				return cliente;
			}
		}
		return null;
	}
	
	@PatchMapping
	public Cliente patchCliente(@RequestBody Cliente modif) {
		for(Cliente cliente : clientes) {
			if(cliente.getId()==modif.getId()) {
				
				if(modif.getNombre()!=null) {
					cliente.setNombre(modif.getNombre());
				}
				if(modif.getPassword()!=null) {
					cliente.setPassword(modif.getPassword());
				}
				if(modif.getUsername()!=null) {
					cliente.setUsername(modif.getUsername());
				}
			return cliente;
			}
		}
		return null;
	}
	*/
}
