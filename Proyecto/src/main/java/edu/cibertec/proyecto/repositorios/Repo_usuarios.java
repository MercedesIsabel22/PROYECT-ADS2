package edu.cibertec.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.proyecto.entity.Capsula_usuario;
import java.util.List;


public interface Repo_usuarios extends JpaRepository<Capsula_usuario, Integer>{

	
	List<Capsula_usuario> findByUsuarioAndClave(String usuario, String clave);
}
