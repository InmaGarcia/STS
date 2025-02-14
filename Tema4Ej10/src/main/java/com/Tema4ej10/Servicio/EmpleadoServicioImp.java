package com.Tema4ej10.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Tema4ej10.Modelo.Empleado;
import com.Tema4ej10.Repositorio.EmpleadoRepoImp;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class EmpleadoServicioImp implements EmpleadoServicio{

	@Autowired
	private EmpleadoRepoImp empRepo;

    public Empleado createOrUpdate(Empleado empleado) {
        return empRepo.save(empleado);
    }

    public Empleado findById(Integer id) {
        return empRepo.findById(id);
    }

    public List<Empleado> findAll() {
        return empRepo.findAll();
    }

    public List<Empleado> findByPuesto(String puesto) {
        return empRepo.findByPuesto(puesto);
    }


    public void deleteById(Integer id) {
    	empRepo.deleteById(id);
    }

}
