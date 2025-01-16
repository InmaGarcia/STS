package Tema4Ej10.Repositorio;

import java.util.List;
import java.util.Map;

import Tema4Ej10.Modelo.Oficina;

public interface OficinaRepositorio {

	public void save(Oficina oficina);
	public Oficina findById(Integer id);
	public List<Oficina> findAll();
	public void deleteById(Integer id);
	public long countEmpleadosInOficina(Integer oficinaId);
	public Map<Integer, Long> getEmpleadosCountPerOficina();
	public List<Oficina> findByMinEmpleados(int minEmpleados);
	public void updateTelefonoByEmpleadoId(Integer empleadoId, String nuevoTelefono);
}
