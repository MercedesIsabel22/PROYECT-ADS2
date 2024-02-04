package edu.cibertec.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.proyecto.entity.CapsulaUsuario;

import java.util.List;


public interface UsuariosRepository extends JpaRepository<CapsulaUsuario, Long> {


    List<CapsulaUsuario> findByUsuarioAndClave(String usuario, String clave);
}
