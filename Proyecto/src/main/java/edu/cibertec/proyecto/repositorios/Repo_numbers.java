package edu.cibertec.proyecto.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.proyecto.entity.Capsula_number;

@Repository
public interface Repo_numbers extends JpaRepository<Capsula_number,Integer> {

}
