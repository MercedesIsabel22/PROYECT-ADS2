package edu.cibertec.proyecto.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.Capsula_operacion;
import edu.cibertec.proyecto.repositorios.Repo_operaciones;
import edu.cibertec.proyecto.servicios.Serv_operaciones;

@Service
public class Seim_operaciones implements Serv_operaciones{
	@Autowired
	Repo_operaciones ro;
	
	@Override
	public void crearOperaciones(Capsula_operacion obj) {
		
		ro.save(obj);
		
	}

	@Override
	public void crearMultiplesOperaciones(List<Capsula_operacion> obj) {
		
		ro.saveAll(obj);
		
	}

}
