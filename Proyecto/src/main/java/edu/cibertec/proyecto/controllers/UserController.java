package edu.cibertec.proyecto.controllers;

import edu.cibertec.proyecto.entity.CapsulaUsuario;
import edu.cibertec.proyecto.services.IUserService;
import edu.cibertec.proyecto.util.AuthUtil;
import edu.cibertec.proyecto.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth/api")
public class UserController {
    @Autowired
    private IUserService service;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private AuthUtil authUtil;

    @PutMapping
    public ResponseEntity<MessageUtil> update(@RequestBody CapsulaUsuario user) {
        user.setClave(passwordEncoder.encode(user.getClave()));
        return authUtil.responseEntityMono(service.update(user),
                "Usuario actualizado correctamente",
                "No se encontró el usuario que intenta actualizar.");
    }

    @GetMapping
    public ResponseEntity<CapsulaUsuario> findByUsername(@RequestParam(name = "username") String username) {
        return service.findByUsername(username)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<CapsulaUsuario>> findAll() {
        List<CapsulaUsuario> resp = service.findAll().stream()
                .peek(u -> u.setClave("")).collect(Collectors.toList());
        return ResponseEntity.ok(resp);
    }
}
