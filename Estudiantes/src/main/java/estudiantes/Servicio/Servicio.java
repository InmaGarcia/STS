package estudiantes.Servicio;

import java.util.List;

import estudiantes.Modelo.Curso;
import estudiantes.Modelo.Estudiante;

public interface Servicio {

	void createUpdateCurso(Curso curso);

	void createUpdateEstudiante(Estudiante estudiante);

	void agregarEstudianteACurso(Estudiante e, Curso c);

	List<Curso> findAllC();

	List<Estudiante> findAllE();

	Curso cursoId(Integer id);

	void eliminarEstudianteDeCurso(Estudiante e, Curso c);

	void deleteC(Integer id);

	Estudiante estudianteId(Integer id);

	void actualizarEmail(String email, Integer id);

	List<Estudiante> buscarEstudiantePOrCadena(String cadena);

}
