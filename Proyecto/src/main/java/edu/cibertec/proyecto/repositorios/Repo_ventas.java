package edu.cibertec.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.proyecto.entity.Capsula_venta;
@Repository
public interface Repo_ventas extends JpaRepository<Capsula_venta, String>{

}
