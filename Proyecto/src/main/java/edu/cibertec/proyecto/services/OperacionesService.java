package edu.cibertec.proyecto.services;

import java.util.List;

import edu.cibertec.proyecto.entity.CapsulaOperacion;

public interface OperacionesService {

	public void crearOperaciones(CapsulaOperacion obj);
	public void crearMultiplesOperaciones(List<CapsulaOperacion> obj);

}
