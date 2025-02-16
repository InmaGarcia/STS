package Deportista.Controlador;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Deportista.Modelo.Deporte;
import Deportista.Modelo.Deportista;
import Deportista.Servicio.Servicio;


@Controller
@RequestMapping("/deportistas")
public class HomeController {

	@Autowired
	private Servicio servicio;
	
	@GetMapping
	public String listaDeportistas(Model model) {
		model.addAttribute("deportistas", servicio.listaDeportistas());
		return "deportistas-lista";
	}
	
	@GetMapping("/altaDeportista")
	public String altaDeportista(Model model) {
		model.addAttribute("deportes", servicio.listaDeportes());
		model.addAttribute("deportista", new Deportista());
		return "deportista-form";
	}
	
	@PostMapping("/guardarDeportista")
	public String guardarDeportista(@RequestParam List<Long> lista,@ModelAttribute Deportista deportista) {
		Set<Deporte> deportes = new HashSet<>();
		for(Long deporte : lista) {
			Deporte d = servicio.deporteId(deporte);
			deportes.add(d);
		}
		deportista.setDeportes(deportes);
		servicio.crearDeportista(deportista);
		return "redirect:/deportistas";
	}
	
	@GetMapping("/deportes")
	public String listaDeportes(Model model) {
		model.addAttribute("deportes", servicio.listaDeportes());
		return "deportes-lista";
	}
	
	@GetMapping("/altaDeporte")
	public String altaDeporte(Model model) {
		model.addAttribute("deportistas", servicio.listaDeportistas());
		model.addAttribute("deporte", new Deporte());
		return "deporte-form";
	}
	
	@PostMapping("/guardarDeporte")
	public String guardarDeportista(@RequestParam List<Long> lista,@ModelAttribute Deporte deporte) {
		Set<Deportista> deportistas = new HashSet<>();
		for(Long deportista : lista) {
			Deportista d = servicio.deportistaId(deportista);
			if(d!=null) {
				System.out.println(d);
				deportistas.add(d);
				d.getDeportes().add(deporte);
			}

		}
		deporte.setDeportistas(deportistas);
		servicio.crearDeporte(deporte);
		return "redirect:/deportistas/deportes";
	}
	
	@GetMapping("/buscarDeporte")
	public String buscarDeporte() {
		return "buscar-deporte";
	}
	
	@GetMapping("/buscador")
	public String buscardor(@RequestParam("nombre") String nombre, Model model) {
		List<Deportista> deportistas = servicio.buscarDeportistaPorDeporte(nombre);
		System.out.println(deportistas);
		model.addAttribute("deportistas", deportistas);
		return "buscar-deporte";
	}
}
