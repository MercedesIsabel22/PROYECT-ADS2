package edu.cibertec.proyecto.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.Capsula_tipoproducto;
import edu.cibertec.proyecto.repositorios.Repo_tipoproductos;
import edu.cibertec.proyecto.servicios.Serv_tipoproductos;

@Service
public class Seim_tipoproductos implements Serv_tipoproductos{
	@Autowired
	Repo_tipoproductos rt;
	
	@Override
	public List<Capsula_tipoproducto> listar() {
		
		return rt.findAll();
	}

}
