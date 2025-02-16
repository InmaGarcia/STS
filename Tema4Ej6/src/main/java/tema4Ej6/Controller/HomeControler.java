package tema4Ej6.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tema4Ej6.Modelo.Cliente;
import tema4Ej6.Servicio.Servicio;

@Controller
@RequestMapping("/clientes")
public class HomeControler {

	@Autowired
	private Servicio service;
	
    private List<Cliente> clientes = new ArrayList<>();

    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", service.getClientes());
        return "index";
    }

    @GetMapping("/detalles")
    public String detalles(@RequestParam int id, Model model) {
        Cliente cliente = clientes.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
        model.addAttribute("cliente", cliente);
        return "cliente-detalle";
    }

    @GetMapping("/formulario")
    public String formulario(Model model) {
    	model.addAttribute("cliente",new Cliente());
        return "cliente-formulario";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(@ModelAttribute Cliente cliente) {

       /* Direccion direccion = new Direccion(cliente.getDireccion().getCalle(), cliente.getDireccion().getCiudad());
        Cliente nuevoCliente = new Cliente(cliente.getNombre(), direccion);*/

    	System.out.println("nombre: " + cliente.getNombre());
        service.crear(cliente);

        return "redirect:/clientes";
    }

    @GetMapping("/ciudad")
    public String buscarPorCiudad(@ModelAttribute String ciudad, Model model) {
        List<Cliente> filtrados = new ArrayList<>();
        if (ciudad != null) {
            filtrados = clientes.stream()
                    .filter(c -> c.getDireccion().getCiudad().equalsIgnoreCase(ciudad))
                    .toList();
        }
        model.addAttribute("clientes", filtrados);
        return "ciudad";
    }
}
