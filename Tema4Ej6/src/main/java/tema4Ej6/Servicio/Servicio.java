package tema4Ej6.Servicio;

import java.util.List;

import tema4Ej6.Modelo.Cliente;
import tema4Ej6.Modelo.Direccion;

public interface Servicio {
	
	public List<Cliente> getClientes();
		
	public Cliente getCliente(Integer id);
		
	public void crear(Cliente c);
		
	public Cliente actualizar(Cliente c);
	
	public boolean borrar(Integer id);
	
	public Cliente actualizarDireccion(Integer id, Direccion d);
	
	public void actualizarSevilla();
	
	public void actualizarCiudadNombre(String ciudad, String letra);
	
	public List<Cliente> getClientesPorCiudad(String ciudad);

}
