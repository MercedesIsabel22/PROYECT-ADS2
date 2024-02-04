package edu.cibertec.proyecto.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.CapsulaOperacion;
import edu.cibertec.proyecto.repositories.IOperacionesRepository;
import edu.cibertec.proyecto.services.IOperacionesService;

@Service
public class OperacionesServiceImpl implements IOperacionesService {
	@Autowired
	IOperacionesRepository ro;
	
	@Override
	public void crearOperaciones(CapsulaOperacion obj) {
		
		ro.save(obj);
		
	}

	@Override
	public void crearMultiplesOperaciones(List<CapsulaOperacion> obj) {
		
		ro.saveAll(obj);
		
	}

}
