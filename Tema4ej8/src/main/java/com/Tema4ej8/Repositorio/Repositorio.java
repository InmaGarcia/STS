package com.Tema4ej8.Repositorio;

import java.util.List;

import com.Tema4ej8.Modelo.Usuario;

public interface Repositorio {
	
	//Obtener la lista de todos los usuarios.
	public List<Usuario> getUsuarios();
	
	//Obtener los datos de un usuario dado su ID.
	public Usuario getUsuarioId(Integer id);
	
	//Insertar un nuevo usuario.
	public void insertarUsuario(Usuario usu);
	
	//Actualizar los datos de un usuario.
	public void actualizarUsuario(Usuario usu);
	
	//Eliminar un usuario dado su ID.
	public boolean borrarUsuario(Integer id);
}
