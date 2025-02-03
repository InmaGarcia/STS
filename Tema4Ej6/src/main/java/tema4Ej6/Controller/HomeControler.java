package tema4Ej6.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tema4Ej6.Modelo.Cliente;
import tema4Ej6.Modelo.Direccion;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeControler {

    private List<Cliente> clientes = new ArrayList<>();

    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clientes);
        return "index";
    }

    @GetMapping("/detalles")
    public String detalles(@RequestParam int id, Model model) {
        Cliente cliente = clientes.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
        model.addAttribute("cliente", cliente);
        return "cliente-detalle";
    }

    @GetMapping("/formulario")
    public String formulario() {
        return "cliente-formulario";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(
            @RequestParam String nombre,
            @RequestParam String calle,
            @RequestParam String ciudad) {

        Direccion direccion = new Direccion(calle, ciudad);
        Cliente nuevoCliente = new Cliente(nombre, direccion);

        nuevoCliente.setId(clientes.size() + 1);
        clientes.add(nuevoCliente);

        return "redirect:/clientes";
    }

    @GetMapping("/ciudad")
    public String buscarPorCiudad(@RequestParam String ciudad, Model model) {
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
