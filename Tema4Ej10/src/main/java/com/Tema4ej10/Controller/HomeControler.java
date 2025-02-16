package com.Tema4ej10.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Tema4ej10.Modelo.Empleado;
import com.Tema4ej10.Modelo.Oficina;
import com.Tema4ej10.Servicio.EmpleadoServicio;
import com.Tema4ej10.Servicio.OficinaServicio;

@Controller
public class HomeControler {

	@Autowired
	private EmpleadoServicio serviceEmp;
	@Autowired
	private OficinaServicio serviceOfi;
	
	//envia la lista de empleados 
	@GetMapping("/empleados")
	public String empleados(Model model) {
		model.addAttribute("empleados", serviceEmp.findAll());
		return "empleados-lista";
	}
	//va al formulario y crea un empleado
	@GetMapping("/empleado-form")
	public String add(Model model) {
		model.addAttribute("empleado", new Empleado());
		return "empleado-form";
	}
	//guarda un nuevo empleado en la base de datos
	//reenvia a la lista
	@PostMapping("/empleados/guardar")
	public String guardar(@ModelAttribute Empleado empleado) {
		serviceEmp.createOrUpdate(empleado);
		return "redirect:/empleados";
	}
	
	@GetMapping("/oficinas")
	public String oficinas(Model model) {
		model.addAttribute("oficinas", serviceOfi.findAll());
		return "oficinas-lista";
	}
	//va al formulario y crea una oficina
		@GetMapping("/oficina-form")
		public String addOfi(Model model) {
			model.addAttribute("oficina", new Oficina());
			model.addAttribute("empleados", serviceEmp.findAll());
			return "oficina-form";
		}
		
		@PostMapping("/oficina/guardar")
		public String guardarOfi(@RequestParam List<Integer> listEmp, @ModelAttribute Oficina ofi) {
			List<Empleado> emps = new ArrayList<>();
			for(Integer id : listEmp) {
				Empleado e =serviceEmp.findById(id);
				emps.add(e);
			}
			ofi.setEmpleados(emps);
			serviceOfi.createOrUpdate(ofi);
			return "redirect:/oficinas";
		}
		
		@GetMapping("/empleados/oficina/{id}")
		public String mostrarEmpleados(@PathVariable Integer id, Model model) {
			model.addAttribute("oficinas", serviceOfi.findAll());
			if(id != null) {
				System.out.println("llega bien: " + id);
			Oficina ofi =serviceOfi.findById(id);
			System.out.println("num de empl:" + ofi.getEmpleados().size());
			model.addAttribute("listaEmp", ofi.getEmpleados());}
			return "oficinas-lista";
		}
}
