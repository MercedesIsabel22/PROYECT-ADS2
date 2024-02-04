package edu.cibertec.proyecto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.CapsulaVenta;
import edu.cibertec.proyecto.repositories.VentasRepository;
import edu.cibertec.proyecto.services.VentsService;
@Service
public class VentasServiceServiceImpl implements VentsService {
	@Autowired
	VentasRepository rv;
	
	@Override
	public void crearVentas(CapsulaVenta obj) {
		
		rv.save(obj);
		
	}

}
