package tema4Ej6.Servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tema4Ej6.Modelo.Cliente;
import tema4Ej6.Modelo.Direccion;
import tema4Ej6.Repositorio.Repositorio;

@Service
public class ServicioImp implements Servicio {

	@Autowired
	private Repositorio repo;
	
	
		public List<Cliente> getClientes(){
			return repo.getClientes();
		}
		
		public Cliente getCliente(Integer id) {
			return repo.getCliente(id);
		}
	
		@Transactional
		public void crear(Cliente c){
			repo.crear(c);
		}
		
		@Transactional
		public Cliente actualizar(Cliente c){
			List<Cliente> lista = repo.getClientes();
			for(Cliente cliente : lista) {
				if(cliente.getId() == c.getId()) {
					if(c.getNombre()!= null) {
						cliente.setNombre(c.getNombre());
					}
					if(c.getDireccionId()!=null) {
						cliente.setDireccionId(c.getDireccionId());
					}
					repo.actualizar(cliente);
					return cliente;
				}
			}
			return null;
			
		}
	
		@Transactional
		public boolean borrar(Integer id){
			return repo.borrar(id);
		}
		
		@Transactional
		public Cliente actualizarDireccion(Integer id, Direccion d) {
			Cliente c = repo.getCliente(id);
			if(c!=null) {
				d.setId(c.getDireccionId());
			}
			repo.actualizarDireccion(d);
			return c;
		}
		
		@Transactional
		public List<Cliente> actualizarSevilla(){
			List<Cliente> clientes= repo.getClientes();
			List<Cliente> modificados = new ArrayList<>();
			for(Cliente cliente:clientes){
				if(cliente.getNombre().substring(0, 1).equalsIgnoreCase("A")) {
					Direccion d = repo.getDireccion(cliente.getDireccionId());
					d.setCiudad("Sevilla");
					repo.actualizarDireccion(d);
					modificados.add(cliente);
				}
			}
			return modificados;
		}
		
		@Transactional
		public List<Cliente> actualizarCiudad(String ciudad, String letra){
			List<Cliente> clientes= repo.getClientes();
			List<Cliente> modificados = new ArrayList<>();
			for(Cliente cliente:clientes){
				if(cliente.getNombre().substring(0, 1).equalsIgnoreCase(letra)) {
					Direccion d = repo.getDireccion(cliente.getDireccionId());
					d.setCiudad(ciudad);
					repo.actualizarDireccion(d);
					modificados.add(cliente);
				}
			}
			return modificados;
		}
		
		@Transactional
		public List<Cliente> getClientesPorCiudad(String ciudad){
			List<Direccion> direcciones = repo.getDirecciones();
			List<Integer> idDirecciones = new ArrayList<>();
			for(Direccion direccion:direcciones) {
				if(direccion.getCiudad().equalsIgnoreCase(ciudad)) {
					idDirecciones.add(direccion.getId());
				}
			}
			List<Cliente> clientes = repo.getClientes();
			List<Cliente> busqueda = new ArrayList<>();
			for(Cliente cliente : clientes) {
				if(idDirecciones.contains(cliente.getDireccionId())) {
					busqueda.add(cliente);
				}
			}
			return busqueda;
		}
}
