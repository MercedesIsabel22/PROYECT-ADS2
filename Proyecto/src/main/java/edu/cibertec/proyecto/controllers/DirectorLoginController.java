package edu.cibertec.proyecto.controllers;

import edu.cibertec.proyecto.dto.AuthUserDTO;
import edu.cibertec.proyecto.services.IUserService;
import edu.cibertec.proyecto.util.AuthUtil;
import edu.cibertec.proyecto.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.cibertec.proyecto.entity.CapsulaUsuario;
import edu.cibertec.proyecto.services.IUsuariosService;

import java.util.Date;

@Controller
@RequestMapping("/auth")
public class DirectorLoginController {
    @Autowired
    private IUsuariosService SUsuario;
    @Autowired
    private IUserService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private AuthUtil authUtil;

    @GetMapping
    public ModelAndView autentificarUsers() {
        ModelAndView mav = new ModelAndView("autentificacion");
        mav.addObject("pqteusers", new CapsulaUsuario());
        return mav;
    }

    @PostMapping
    public String ejecutarAutentificacion(@ModelAttribute(name = "pqteusers") CapsulaUsuario obj, BindingResult result, RedirectAttributes attribute) {
        final String response = userService.signIn(obj)
                .map(u -> {
                    if (u.getEstado() == 1) {
                        return "redirect:/auth";
                    }
                    return "";
                })
                .orElseGet(() -> "");
        if (response.isEmpty()) {
            attribute.addFlashAttribute("warning", "Datos de usuario incorrectos.");
            return "redirect:/auth";
        }
        return "redirect:/listar_Ctrl_Reposicion";
    }

}
