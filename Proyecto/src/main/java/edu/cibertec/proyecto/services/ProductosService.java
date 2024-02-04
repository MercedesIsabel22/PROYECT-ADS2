package edu.cibertec.proyecto.services;

import java.io.FileNotFoundException;
import java.util.List;

import edu.cibertec.proyecto.entity.CapsulaProducto;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

public interface ProductosService {

	public List<CapsulaProducto> listar();
	public CapsulaProducto buscarProducto(Long codigo);
	public void eliminarProducto(CapsulaProducto obj);
	public void modificarProducto(CapsulaProducto obj);
	public void crearProducto(CapsulaProducto obj);
	public JasperPrint exportReport(String report)throws FileNotFoundException, JRException;
}
