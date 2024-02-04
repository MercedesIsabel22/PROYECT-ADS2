package edu.cibertec.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.proyecto.entity.CapsulaProveedor;

import java.util.List;

@Repository
public interface ProveedoresRepository extends JpaRepository<CapsulaProveedor, Long> {


    List<CapsulaProveedor> findByEstado(int estado);

}
