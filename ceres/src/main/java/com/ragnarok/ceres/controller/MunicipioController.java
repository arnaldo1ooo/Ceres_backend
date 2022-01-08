package com.ragnarok.ceres.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MunicipioController {
	
	@GetMapping("/municipios")
	public String municipio(@RequestParam(name="nombre", required=false, defaultValue="Ninguno") String nombre, Model model) {
		
		model.addAttribute("nombre", nombre);
		
		return "municipio";
	}
	
}
