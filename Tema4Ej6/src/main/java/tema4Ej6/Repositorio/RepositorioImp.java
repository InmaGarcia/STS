package tema4Ej6.Repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import tema4Ej6.Modelo.Cliente;
import tema4Ej6.Modelo.Direccion;

@Repository
public class RepositorioImp implements Repositorio {

	@PersistenceContext
	private EntityManager puente;
	
	@Override
	public List<Cliente> getClientes(){
		return puente.createQuery("select c from Cliente c", Cliente.class).getResultList();
	}
	
	@Override
	public Cliente getCliente(Integer id) {
		return puente.find(Cliente.class, id);
	}
	
	@Override
	public void crear(Cliente c) {
		puente.persist(c);
	}
	
	@Override
	public void actualizar(Cliente c) {
		puente.merge(c);
	}
	
	@Override
	public boolean borrar(Integer id) {
		Cliente c = getCliente(id);
		if(c != null) {
			puente.remove(c);
			return true;
			}else {
				return false;
			}
	}
	
	@Override
	public Direccion getDireccion(Integer id) {
		return puente.createQuery("select d from Direccion d where d.id = :id", Direccion.class).setParameter(id, id).getSingleResult();
	}
	
	@Override
	public void actualizarDireccion(Direccion d) {
		puente.merge(d);
	}
	
	@Override
	public List<Cliente> buscarA(){
		 return puente.createQuery("SELECT c FROM Cliente c WHERE c.nombre LIKE :prefijo", Cliente.class)
         .setParameter("prefijo", "A" + "%")
         .getResultList();
	}
	
	@Override
	public List<Cliente> buscarNombresPorLetra(String letra){
		
		System.out.println("la letra es " + letra);
		 return puente.createQuery("SELECT c FROM Cliente c WHERE c.nombre LIKE :prefix", Cliente.class)
        .setParameter("prefix", letra + "%")
        .getResultList();
	}

	
	@Override
	 public List<Cliente> buscarPorCiudad(String ciudad) {
		
	        String query = "SELECT c FROM Cliente c WHERE c.direccion.ciudad = :ciudad";
	        return puente.createQuery(query, Cliente.class)
	                            .setParameter("ciudad", ciudad)
	                            .getResultList();
	    
		
	    }


}
