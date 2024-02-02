package edu.cibertec.proyecto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.Capsula_venta;
import edu.cibertec.proyecto.repositorios.Repo_ventas;
import edu.cibertec.proyecto.servicios.Serv_ventas;
@Service
public class Seim_ventas implements Serv_ventas {
	@Autowired
	Repo_ventas rv;
	
	@Override
	public void crearVemtas(Capsula_venta obj) {
		
		rv.save(obj);
		
	}

}
