package estudiantes.repositorio;

import java.util.List;

import org.springframework.stereotype.Repository;

import estudiantes.Modelo.Curso;
import estudiantes.Modelo.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RepositorioImp implements Repositorio{
	
	@PersistenceContext
	private EntityManager puente;
	
	@Override
	public void createUpdateCurso(Curso curso) {
		if(curso.getId() == null) {
			puente.persist(curso);
		}else {
			puente.merge(curso);
		}
	}
	
	@Override
	public void createUpdateEstudiante(Estudiante estudiante) {
		if(estudiante.getId() == null) {
			puente.persist(estudiante);
		}else {
			puente.merge(estudiante);
		}
	}

	@Override
	public Estudiante estudianteId(Integer id) {
		return puente.find(Estudiante.class, id);
	}
	
	@Override
	public Curso cursoId(Integer id) {
		return puente.find(Curso.class, id);
	}
	
	@Override
	public List<Curso> findAllC(){
		return puente.createQuery("FROM Curso c", Curso.class).getResultList();
	}
	
	@Override
	public List<Estudiante> findAllE(){
		return puente.createQuery("FROM Estudiante e", Estudiante.class).getResultList();
	}
	
	@Override
	public void deleteC(Integer id) {
		Curso c = cursoId(id);
		if(c !=null) {
			puente.remove(c);
		}
	}
	
	@Override
	public List<Estudiante> buscarEstudiantePorCadena(String cadena) {
		String sql = "SELECT e FROM Estudiante e WHERE e.nombre LIKE :cadena";
		return puente.createQuery(sql, Estudiante.class).setParameter("cadena", "%"+cadena+"%").getResultList();
	}
}
