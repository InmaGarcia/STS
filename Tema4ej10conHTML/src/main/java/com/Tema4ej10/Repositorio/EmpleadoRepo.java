package com.Tema4ej10.Repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.Tema4ej10.Modelo.Empleado;

@Repository
public interface EmpleadoRepo {


	public Empleado save(Empleado empleado);

	public Empleado findById(Integer id);

	public List<Empleado> findAll();

	public List<Empleado> findByPuesto(String puesto);


	public void deleteById(Integer id);

	long countEmpleadosByOficinaId(Integer oficinaId);

}
