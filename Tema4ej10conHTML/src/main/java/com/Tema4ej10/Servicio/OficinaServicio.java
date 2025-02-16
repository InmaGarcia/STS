package com.Tema4ej10.Servicio;

import java.util.List;
import java.util.Map;

import com.Tema4ej10.Modelo.Oficina;

public interface OficinaServicio {


	public Oficina createOrUpdate(Oficina oficina);

	public Oficina findById(Integer id);

	public List<Oficina> findAll();

	public Integer countEmpleadosByOficina(Integer oficinaId);

	public List<Oficina> findWithMoreThanNEmpleados(Long n);

	public void deleteById(Integer id);

	Map<Integer, Long> getMapaOficinasConEmpleados();

	void updateTelefonoByEmpleadoId(Integer empleadoId, String telefono);

}
