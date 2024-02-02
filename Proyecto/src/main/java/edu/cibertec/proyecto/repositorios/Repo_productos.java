package edu.cibertec.proyecto.repositorios;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.proyecto.entity.Capsula_producto;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
@Repository
public interface Repo_productos extends JpaRepository<Capsula_producto, Integer>{
	
	List<Capsula_producto> findByEstado(int estado);
	
	
}
