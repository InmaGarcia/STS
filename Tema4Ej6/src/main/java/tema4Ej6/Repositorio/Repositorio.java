package tema4Ej6.Repositorio;

import java.util.List;

import tema4Ej6.Modelo.Cliente;
import tema4Ej6.Modelo.Direccion;

public interface Repositorio {

	//Obtener la lista de todos los clientes.
	public List<Cliente> getClientes();
	//Obtener los datos de un cliente dado su ID
	public Cliente getCliente(Integer id);
	//Insertar un nuevo cliente
	public void crear(Cliente c);
	//Actualizar los datos de un cliente.
	public void actualizar(Cliente c);
	//Eliminar un cliente dado su ID.
	public boolean borrar(Integer id);
	//Tomar la direccion por la id
	public Direccion getDireccion(Integer id);
	//actualizar direccion
	public void actualizarDireccion(Direccion d);
	//
	public List<Cliente> buscarA();
	//
	public List<Cliente> buscarNombresPorLetra(String letra);
	//
	public List<Cliente> buscarPorCiudad(String ciudad);
}
