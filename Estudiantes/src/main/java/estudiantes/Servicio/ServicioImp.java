package estudiantes.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estudiantes.Modelo.Curso;
import estudiantes.Modelo.Estudiante;
import estudiantes.repositorio.Repositorio;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServicioImp implements Servicio{

	@Autowired
	private Repositorio repo;
	
	@Override
	public void createUpdateCurso(Curso curso) {
		repo.createUpdateCurso(curso);
	}
	
	@Override
	public void createUpdateEstudiante(Estudiante estudiante) {
		repo.createUpdateEstudiante(estudiante);
	}
	
	@Override
	public void agregarEstudianteACurso(Estudiante e, Curso c) {
		Estudiante estudiante = repo.estudianteId(e.getId());
		Curso curso = repo.cursoId(c.getId());
		
		if(estudiante != null && curso != null) {
			curso.getEstudiantes().add(estudiante);
			repo.createUpdateCurso(curso);
		}
	}
	
	@Override
	public Curso cursoId(Integer id) {
		return repo.cursoId(id);		
	}
	
	@Override
	public Estudiante estudianteId(Integer id) {
		return repo.estudianteId(id);		
	}
	
	@Override
	public List<Curso> findAllC(){
		return repo.findAllC();
	}
	
	@Override
	public List<Estudiante> findAllE(){
		return repo.findAllE();
	}
	
	@Override
	public void eliminarEstudianteDeCurso(Estudiante e, Curso c) {
		Estudiante e1= repo.estudianteId(e.getId());
		Curso c1 = repo.cursoId(c.getId());
		
		if(e1 !=null && c1 !=null) {
			c1.getEstudiantes().remove(e1);
			repo.createUpdateCurso(c1);
		}
	}
	
	@Override
	public void deleteC(Integer id) {
		repo.deleteC(id);
	}
	
	@Override
	public void actualizarEmail(String email, Integer id) {
		Estudiante e = repo.estudianteId(id);
		if(e != null) {
			e.setEmail(email);
			repo.createUpdateEstudiante(e);
		}
	}
	
	@Override
	public List<Estudiante> buscarEstudiantePOrCadena(String cadena){
		return repo.buscarEstudiantePorCadena(cadena);
	}
}
