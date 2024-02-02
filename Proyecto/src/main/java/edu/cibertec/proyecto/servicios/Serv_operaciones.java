package edu.cibertec.proyecto.servicios;

import java.util.List;

import edu.cibertec.proyecto.entity.Capsula_operacion;

public interface Serv_operaciones {

	public void crearOperaciones(Capsula_operacion obj);
	public void crearMultiplesOperaciones(List<Capsula_operacion> obj);

}
