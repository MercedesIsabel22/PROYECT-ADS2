package edu.cibertec.proyecto.services;

import java.util.List;

import edu.cibertec.proyecto.entity.CapsulaCliente;

public interface IClientesService {
	
	public List<CapsulaCliente> listar();
	public CapsulaCliente buscarCliente(Long codigo);
	public void eliminarCliente(CapsulaCliente obj);
	public void modificarCliente(CapsulaCliente obj);
	public void crearCliente(CapsulaCliente obj);
	
	
}
