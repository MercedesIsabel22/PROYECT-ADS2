package edu.cibertec.proyecto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.CapsulaVenta;
import edu.cibertec.proyecto.repositories.IVentasRepository;
import edu.cibertec.proyecto.services.IVentsService;
@Service
public class VentasServiceServiceImpl implements IVentsService {
	@Autowired
	IVentasRepository rv;
	
	@Override
	public void crearVentas(CapsulaVenta obj) {
		
		rv.save(obj);
		
	}

}
