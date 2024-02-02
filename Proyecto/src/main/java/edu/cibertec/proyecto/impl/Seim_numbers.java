package edu.cibertec.proyecto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.Capsula_number;
import edu.cibertec.proyecto.repositorios.Repo_numbers;
import edu.cibertec.proyecto.servicios.Serv_numbers;
@Service
public class Seim_numbers implements Serv_numbers{
	@Autowired
	Repo_numbers rn;
	@Override
	public Capsula_number buscarNumeracion(int id) {
		Capsula_number num = rn.findById(id).orElse(null);
		int correl = num.getNumeracion() + 1;
		num.setNumeracion(correl);
		rn.save(num);
		return rn.findById(id).orElse(null);
	}

	
	
}
