package Tema4Ej10.Servicio;

import java.util.List;
import java.util.Map;

import Tema4Ej10.Modelo.Oficina;

public interface OficinaServicio {
	
	public void crearOficina(Oficina oficina);
	public Oficina obtenerOficinaPorId(Integer id);
	public List<Oficina> listarOficinas();
	public void eliminarOficina(Integer id);
	public long contarEmpleadosEnOficina(Integer oficinaId);
	public Map<Integer, Long> empleadosPorOficina();
	public List<Oficina> oficinasConMasDeNEmpleados(int n);
	public void actualizarTelefonoOficinaPorEmpleadoId(Integer empleadoId, String nuevoTelefono);
}
