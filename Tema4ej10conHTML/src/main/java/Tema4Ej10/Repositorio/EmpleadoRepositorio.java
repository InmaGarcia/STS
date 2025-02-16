package Tema4Ej10.Repositorio;

import java.util.List;

import Tema4Ej10.Modelo.Empleado;

public interface EmpleadoRepositorio {
	
	public void save(Empleado empleado);
	public Empleado findById(Integer id);
	public List<Empleado> findAll();
	public void deleteById(Integer id);
	public List<Empleado> findByPuesto(String puesto);
}
