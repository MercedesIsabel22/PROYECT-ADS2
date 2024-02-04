package edu.cibertec.proyecto.repositories;

import edu.cibertec.proyecto.entity.CapsulaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.proyecto.entity.CapsulaOperacion;

import java.util.List;

@Repository
public interface IOperacionesRepository extends JpaRepository<CapsulaOperacion, Long> {
    List<CapsulaOperacion> findByProducto(CapsulaProducto producto);

}
