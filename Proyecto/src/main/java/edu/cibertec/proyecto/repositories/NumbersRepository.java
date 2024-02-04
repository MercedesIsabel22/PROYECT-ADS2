package edu.cibertec.proyecto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.proyecto.entity.CapsulaNumber;

@Repository
public interface NumbersRepository extends JpaRepository<CapsulaNumber, Long> {

}
