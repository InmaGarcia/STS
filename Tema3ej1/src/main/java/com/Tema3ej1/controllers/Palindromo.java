package com.Tema3ej1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Palindromo {

	@GetMapping("/validar-palindromo/{palabra}")
		public String getPalindromo(@PathVariable String palabra) {
			
			String mensaje = "La palabra " + palabra;
			if( esPalindromo(palabra)) {
				return mensaje + " SI es un palindromo";
			}
			else {
				return mensaje + " NO es un palindromo";
			}
			
			
		}
	
	private boolean esPalindromo(String palabra) {
		int longitud = palabra.length();
		
		for(int i=0; i<longitud/2; i++) {
			if(palabra.charAt(i) != palabra.charAt(longitud - i -1)) {
				return false;
			}
		}
		return true;
	}
}
