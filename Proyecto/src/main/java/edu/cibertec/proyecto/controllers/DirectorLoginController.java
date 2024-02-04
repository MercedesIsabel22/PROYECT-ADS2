package edu.cibertec.proyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.cibertec.proyecto.entity.CapsulaUsuario;
import edu.cibertec.proyecto.services.UsuariosService;

@Controller
@RequestMapping("/")
public class DirectorLoginController {
	@Autowired
    UsuariosService SUsuario;
	
	@GetMapping("autentificar")
	public ModelAndView autentificarUsers() {
		ModelAndView mav = new ModelAndView("autentificacion");
		mav.addObject("pqteusers",new CapsulaUsuario());
		return mav;
	}
	
	@PostMapping("/ejecutar_autentificacion")
	public String ejecutarAutentificacion(@ModelAttribute (name = "pqteusers") CapsulaUsuario obj, BindingResult result, RedirectAttributes attribute) {
	
		boolean val = SUsuario.validarLogin(obj.getUsuario(),obj.getClave());
		if (val==false) {
			attribute.addFlashAttribute("warning","Datos de usuario incorrectos.");
			return "redirect:/autentificar";
		}
		
		return "redirect:/listar_Ctrl_Reposicion";
	}
	
}
