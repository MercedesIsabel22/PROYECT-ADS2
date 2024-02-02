package edu.cibertec.proyecto.servicios;

import java.util.List;

import edu.cibertec.proyecto.entity.Capsula_cliente;

public interface Serv_clientes {
	
	public List<Capsula_cliente> listar();
	public Capsula_cliente buscarCliente(int codigo);
	public void eliminarCliente(Capsula_cliente obj);
	public void modificarCliente(Capsula_cliente obj);
	public void crearCliente(Capsula_cliente obj);
	
	
}
