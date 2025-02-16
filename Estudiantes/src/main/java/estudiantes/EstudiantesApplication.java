package estudiantes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import estudiantes.Modelo.Curso;
import estudiantes.Modelo.Estudiante;
import estudiantes.Servicio.Servicio;

@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EstudiantesApplication.class, args);
	}

	@Autowired
	private Servicio servicio;
	
	@Override
	public void run(String... args) throws Exception {
		
		Curso daw = new Curso();
		daw.setNombre("Desarrollo Aplicaciones Web");
		daw.setDescripcion("DAW");
		
		servicio.createUpdateCurso(daw);
		
		Curso dam = new Curso();
		dam.setNombre("Desarrollo Aplicaciones Multiplataforma");
		dam.setDescripcion("DAM");
		
		servicio.createUpdateCurso(dam);
		
		Estudiante e1 = new Estudiante();
		e1.setNombre("Inmaculada");
		e1.setEmail("inmaculada@ceu.es");
		
		servicio.createUpdateEstudiante(e1);
		
		servicio.agregarEstudianteACurso(e1, daw);
		
		System.out.println(servicio.cursoId(1));
		
		//servicio.eliminarEstudianteDeCurso(e1, daw);
		
		//servicio.deleteC(1);
		System.out.println(servicio.findAllE());
		System.out.println(servicio.estudianteId(1));
		
		servicio.actualizarEmail("imyta@ceu.es", 1);
		
		System.out.println(servicio.buscarEstudiantePOrCadena("lada"));
	}

}
