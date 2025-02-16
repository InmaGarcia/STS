package estudiantes.repositorio;

import java.util.List;

import estudiantes.Modelo.Curso;
import estudiantes.Modelo.Estudiante;

public interface Repositorio {
	//Crear un curso
	void createUpdateCurso(Curso curso);
	//Crear un estudiante
	void createUpdateEstudiante(Estudiante estudiante);
	//Buscar estudiante por id
	Estudiante estudianteId(Integer id);
	//Buscar curso por id
	Curso cursoId(Integer id);
	//Consultar todos los cursos
	List<Curso> findAllC();
	//Consultar todos los estudiantes
	List<Estudiante> findAllE();
	//Buscar los cursos cuyo nombre contengan una palabra
	void deleteC(Integer id);
	List<Estudiante> buscarEstudiantePorCadena(String cadena);

}
