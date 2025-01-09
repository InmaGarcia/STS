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
		public Cliente actualizar(Cliente c, Direccion nueva){

			
			Cliente cliente = repo.getCliente(c.getId());
			if (cliente != null) {
				if (nueva != null) {
					nueva.setId(cliente.getDireccion().getId());
					cliente.setDireccion(nueva);
					repo.crear(cliente);
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
				if (d != null) {
					d.setId(c.getDireccion().getId());
					c.setDireccion(d);
					repo.actualizar(c);
					return c;
				}

			}
			return null;
		}
		
		@Transactional
		public void actualizarSevilla(){
			List<Cliente> clientes = repo.buscarA();
	        for (Cliente cliente : clientes) {
	            if (cliente.getDireccion() != null) {
	                cliente.getDireccion().setCiudad("Sevilla");
	                repo.actualizar(cliente);
	            }
	        }

		}
		
		@Transactional
		public void actualizarCiudadNombre(String ciudad, String letra){
			List<Cliente> clientes= repo.buscarNombresPorLetra(letra);
			for(Cliente cliente:clientes){
				if (cliente.getDireccion() != null) {
	                cliente.getDireccion().setCiudad(ciudad);
	                repo.actualizar(cliente);
	            }

			}
		}
		
		@Transactional
		public List<Cliente> getClientesPorCiudad(String ciudad){
			 return repo.buscarPorCiudad(ciudad);
		}

		@Override
		public Cliente actualizar(Cliente c) {
			// TODO Auto-generated method stub
			return null;
		}
}
