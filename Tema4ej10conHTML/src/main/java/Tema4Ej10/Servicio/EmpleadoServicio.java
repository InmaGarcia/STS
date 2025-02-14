package Tema4Ej10.Servicio;

import java.util.List;

import Tema4Ej10.Modelo.Empleado;

public interface EmpleadoServicio {
	
	public void crearEmpleado(Empleado empleado);
 	public Empleado obtenerEmpleadoPorId(Integer id);
 	public List<Empleado> listarEmpleados();
 	public void actualizarEmpleado(Empleado empleado);
 	public void eliminarEmpleado(Integer id);
 	public List<Empleado> empleadosPorPuesto(String puesto);
}
