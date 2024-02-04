package edu.cibertec.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.proyecto.entity.CapsulaCliente;

import java.util.List;

@Repository
public interface ClientesRepository extends JpaRepository<CapsulaCliente, Long> {

    List<CapsulaCliente> findByEstado(int estado);
}
