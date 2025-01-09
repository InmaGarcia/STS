package com.Tema4ej8.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tema4ej8.Modelo.Usuario;
import com.Tema4ej8.Repositorio.Repositorio;

@Service
public class ServicioImp implements Servicio {
	
	@Autowired
	private Repositorio repo;
	
	@Override
	public List<Usuario> getUsuarios(){
		return repo.getUsuarios();
	}
	
	@Override
	public Usuario getUsuarioId(Integer id) {
		return repo.getUsuarioId(id);
	}
	
	@Override
	public void insertarUsuario(Usuario usu) {
		repo.insertarUsuario(usu);;
	}
	
	@Override
	public void actualizarUsuario(Usuario usu) {
		repo.actualizarUsuario(usu);;
	}
	
	@Override
	public boolean borrarUsuario(Integer id) {
		return repo.borrarUsuario(id);
	}

}
