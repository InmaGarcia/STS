package com.Tema4ej8.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Tema4ej8.Modelo.Usuario;
import com.Tema4ej8.Servicio.Servicio;

@RestController
@RequestMapping("/api/usuario")
public class Controlador {

	@Autowired
	private Servicio servicio;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getUsuarios(){
		List<Usuario> lista = servicio.getUsuarios();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> insertarUsuario(Usuario user){
		servicio.insertarUsuario(user);
		return ResponseEntity.ok(user);
	}
	
}
