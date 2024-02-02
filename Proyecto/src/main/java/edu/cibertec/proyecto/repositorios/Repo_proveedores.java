package edu.cibertec.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.proyecto.entity.Capsula_proveedor;
import java.util.List;

@Repository
public interface Repo_proveedores extends JpaRepository<Capsula_proveedor, Integer>{

	
	List<Capsula_proveedor> findByEstado(int estado);
	
}
