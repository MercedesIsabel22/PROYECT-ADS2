package edu.cibertec.proyecto.servicios;

import java.io.FileNotFoundException;
import java.util.List;

import edu.cibertec.proyecto.entity.Capsula_producto;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

public interface Serv_productos {

	public List<Capsula_producto> listar();
	public Capsula_producto buscarProducto(int codigo);
	public void eliminarProducto(Capsula_producto obj);
	public void modificarProducto(Capsula_producto obj);
	public void crearProducto(Capsula_producto obj);
	public JasperPrint exportReport(String report)throws FileNotFoundException, JRException;
}
