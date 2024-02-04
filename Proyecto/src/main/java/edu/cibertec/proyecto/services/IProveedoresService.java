package edu.cibertec.proyecto.services;

import java.util.List;

import edu.cibertec.proyecto.entity.CapsulaProveedor;

public interface IProveedoresService {

	public List<CapsulaProveedor> listar();
	public CapsulaProveedor buscarProveedor(Long codigo);
	public void eliminarProveedor(CapsulaProveedor obj);
	public void modificarProveedor(CapsulaProveedor obj);
	public void crearProveedor(CapsulaProveedor obj);
	
}
