package edu.cibertec.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.proyecto.entity.CapsulaTipoProducto;

@Repository
public interface ITipoProductosRepository extends JpaRepository<CapsulaTipoProducto, Long> {

}
