package edu.cibertec.proyecto.servicios;

import java.util.List;

import edu.cibertec.proyecto.entity.Capsula_proveedor;

public interface Serv_proveedores {

	public List<Capsula_proveedor> listar();
	public Capsula_proveedor buscarProveedor(int codigo);
	public void eliminarProveedor(Capsula_proveedor obj);
	public void modificarProveedor(Capsula_proveedor obj);
	public void crearProveedor(Capsula_proveedor obj);
	
}
