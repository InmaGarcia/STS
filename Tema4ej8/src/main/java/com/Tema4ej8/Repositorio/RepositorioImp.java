package com.Tema4ej8.Repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.Tema4ej8.Modelo.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RepositorioImp implements Repositorio{

	@PersistenceContext
	private EntityManager puente;
	
	@Override
	public List<Usuario> getUsuarios(){
		return puente.createQuery("SELECT u FROM usuario u", Usuario.class).getResultList();
	}
	
	@Override
	public Usuario getUsuarioId(Integer id) {
		return puente.find(Usuario.class, id);
	}
	
	@Override
	public void insertarUsuario(Usuario usu) {
		puente.persist(usu);
	}
	
	@Override
	public void actualizarUsuario(Usuario usu) {
		puente.merge(usu);
	}
	
	@Override
	public boolean borrarUsuario(Integer id) {
		Usuario u = getUsuarioId(id);
		if(u != null) {
			puente.remove(u);
			return true;
			}else {
				return false;
			}
	}
}
