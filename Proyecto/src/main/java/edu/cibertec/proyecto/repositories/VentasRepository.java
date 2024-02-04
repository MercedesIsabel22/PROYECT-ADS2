package edu.cibertec.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.proyecto.entity.CapsulaVenta;
@Repository
public interface VentasRepository extends JpaRepository<CapsulaVenta, String>{

}
