package com.Tema4ej10.Servicio;

import java.util.List;

import com.Tema4ej10.Modelo.Empleado;

public interface EmpleadoServicio {

	public Empleado createOrUpdate(Empleado empleado);

	public Empleado findById(Integer id);

	public List<Empleado> findAll();

	public List<Empleado> findByPuesto(String puesto);

	public void deleteById(Integer id);


}
