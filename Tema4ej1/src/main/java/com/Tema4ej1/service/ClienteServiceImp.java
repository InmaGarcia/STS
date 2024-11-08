package com.Tema4ej1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Tema4ej1.modelo.Cliente;
import com.Tema4ej1.respository.ClienteRepositoryImp;

@Service
public class ClienteServiceImp {
	
	@Autowired
	private ClienteRepositoryImp repo;
	
	public List<Cliente> getClientes() {
		List<Cliente> clientes = repo.getClientes();
		return clientes;
		
	}
	
	public Cliente getCliente(Integer id) {
		Cliente c = repo.getCliente(id);
		return c;
		
	}

	@Transactional
	public void insertarCliente(Cliente c) {
		repo.insertarCliente(c);
	}
	
	@Transactional
	public void borrarCliente(Integer id) {
		repo.borrarCliente(id);
	}
	
	
}
