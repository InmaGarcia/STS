package estudiantes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import estudiantes.Modelo.Curso;
import estudiantes.Modelo.Estudiante;
import estudiantes.Servicio.Servicio;

@Controller
public class HomeController {

	@Autowired
	private Servicio servicio;

	@GetMapping("/cursos/listado")
	public String listado(Model model) {
		model.addAttribute("cursos", servicio.findAllC());
		return "cursos-lista";
	}
	
	@GetMapping("/cursos")
	public String index() {
		return "index";
	}

	@GetMapping("/cursos/crear")
	public String altaCurso(Model model) {
		model.addAttribute("curso", new Curso());
		return "curso-form";
	}

	@PostMapping("/cursos/guardar")
	public String guardarCurso(@ModelAttribute Curso c, Model model) {
		if (c != null) {
			servicio.createUpdateCurso(c);
		}
		return "redirect:/cursos/listado";
	}
	
	@GetMapping("/estudiantes/crear")
	public String altaEstudiante(Model model) {
		model.addAttribute("cursos", servicio.findAllC());
		model.addAttribute("estudiante", new Estudiante());
		return "estudiante-form";
	}
	
	@PostMapping("/estudiantes/guardar")
	public String guardarEstudiante(@ModelAttribute Estudiante e, Model model) {
		
		if(e != null){
			servicio.createUpdateEstudiante(e);
		}
		return "redirect:/cursos/listado";
		
	}
}
