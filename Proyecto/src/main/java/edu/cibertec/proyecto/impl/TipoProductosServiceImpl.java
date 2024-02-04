package edu.cibertec.proyecto.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.CapsulaTipoProducto;
import edu.cibertec.proyecto.repositories.ITipoProductosRepository;
import edu.cibertec.proyecto.services.ITipoProductosService;

@Service
public class TipoProductosServiceImpl implements ITipoProductosService {
	@Autowired
	ITipoProductosRepository rt;
	
	@Override
	public List<CapsulaTipoProducto> listar() {
		
		return rt.findAll();
	}

}
