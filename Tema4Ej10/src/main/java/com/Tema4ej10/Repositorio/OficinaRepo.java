package com.Tema4ej10.Repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.Tema4ej10.Modelo.Oficina;

@Repository
public interface OficinaRepo {
	public Oficina save(Oficina oficina);

	public Oficina findById(Integer id);

	public List<Oficina> findAll();

	//public Long countEmpleadosByOficina(Integer oficinaId);

	//public List<Oficina> findWithMoreThanNEmpleados(Long n);

	public void deleteById(Integer id);
	
	void updateTelefonoByEmpleadoId(Integer empleadoId, String telefono);

	
}
