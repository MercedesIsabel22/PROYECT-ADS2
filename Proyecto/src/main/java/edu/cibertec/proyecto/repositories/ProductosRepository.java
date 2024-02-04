package edu.cibertec.proyecto.repositories;

import java.util.List;

import edu.cibertec.proyecto.entity.CapsulaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<CapsulaProducto, Long> {

    List<CapsulaProducto> findByEstado(int estado);


}
