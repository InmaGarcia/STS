package com.PruebaAplicWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.PruebaAplicWeb.model.User;



@Controller
public class HomeControler {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("mensaje", "Bienvenido a clase");
		model.addAttribute("nombre1", "Inmaculada");
		model.addAttribute("nombre2", "<b>Inmaculada</b>");
		model.addAttribute("ruta", "index.html");
		model.addAttribute("role", "admin");
		
		String [] nombres={"Pepe","Clara","María","Francisco","Manuel"};
		model.addAttribute("nombres", nombres);
		return "home";
	}
	
	@GetMapping("/index")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("user", new User());
		return "form";
	}
	
	//este metodo se ejecuta cuando el formulario envia los datos
	//busca el endpoint (/form) y el metodo (post)
	@PostMapping("/form")
	public String user(@ModelAttribute User user,Model model) {
		model.addAttribute("mensaje","Formulario enviado con éxito");
		model.addAttribute("user",user);
		return "result";
	}
	
}
