package edu.cibertec.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.proyecto.entity.Capsula_operacion;
import java.util.List;
import edu.cibertec.proyecto.entity.Capsula_producto;

@Repository
public interface Repo_operaciones extends JpaRepository<Capsula_operacion, Integer>{
	
	List<Capsula_operacion> findByProducto(Capsula_producto producto);
	
}
