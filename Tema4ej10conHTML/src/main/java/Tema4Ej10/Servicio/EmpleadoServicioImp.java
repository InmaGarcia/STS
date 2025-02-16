package Tema4Ej10.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tema4Ej10.Modelo.Empleado;
import Tema4Ej10.Repositorio.EmpleadoRepositorioImp;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmpleadoServicioImp implements EmpleadoServicio{

	 @Autowired
	    private EmpleadoRepositorioImp empRepo;

	    @Override
	    public void crearEmpleado(Empleado empleado) {
	    	empRepo.save(empleado);
	    }

	    @Override
	    public Empleado obtenerEmpleadoPorId(Integer id) {
	        return empRepo.findById(id);
	    }

	    @Override
	    public List<Empleado> listarEmpleados() {
	        return empRepo.findAll();
	    }

	    @Override
	    public void actualizarEmpleado(Empleado empleado) {
	    	empRepo.save(empleado);
	    }

	    @Override
	    public void eliminarEmpleado(Integer id) {
	    	empRepo.deleteById(id);
	    }

	    @Override
	    public List<Empleado> empleadosPorPuesto(String puesto) {
	        return empRepo.findByPuesto(puesto);
	    }
}
