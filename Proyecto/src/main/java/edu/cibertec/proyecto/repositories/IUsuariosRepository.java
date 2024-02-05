package edu.cibertec.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.proyecto.entity.CapsulaUsuario;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUsuariosRepository extends JpaRepository<CapsulaUsuario, Long> {
    List<CapsulaUsuario> findByUsuarioAndClave(String usuario, String clave);

    Optional<CapsulaUsuario> findByUsuario(String username);
}
