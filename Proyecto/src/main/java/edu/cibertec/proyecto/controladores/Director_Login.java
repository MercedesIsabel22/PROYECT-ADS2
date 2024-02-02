package edu.cibertec.proyecto.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.qos.logback.core.model.Model;
import edu.cibertec.proyecto.entity.Capsula_cliente;
import edu.cibertec.proyecto.entity.Capsula_usuario;
import edu.cibertec.proyecto.servicios.Serv_usuarios;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class Director_Login {
	@Autowired
	Serv_usuarios SUsuario;
	
	@GetMapping("autentificar")
	public ModelAndView autentificarUsers() {
		ModelAndView mav = new ModelAndView("autentificacion");
		mav.addObject("pqteusers",new Capsula_usuario());
		return mav;
	}
	
	@PostMapping("/ejecutar_autentificacion")
	public String ejecutarAutentificacion(@ModelAttribute (name = "pqteusers")Capsula_usuario obj,BindingResult result,RedirectAttributes attribute) {
	
		boolean val = SUsuario.validarLogin(obj.getUsuario(),obj.getClave());
		if (val==false) {
			attribute.addFlashAttribute("warning","Datos de usuario incorrectos.");
			return "redirect:/autentificar";
		}
		
		return "redirect:/listar_Ctrl_Reposicion";
	}
	
}
