package edu.cibertec.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.proyecto.entity.Capsula_tipoproducto;
@Repository
public interface Repo_tipoproductos extends JpaRepository<Capsula_tipoproducto, Integer> {

}
