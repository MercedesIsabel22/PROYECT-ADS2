package edu.cibertec.proyecto.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import edu.cibertec.proyecto.entity.Capsula_producto;
import edu.cibertec.proyecto.repositorios.Repo_productos;
import edu.cibertec.proyecto.servicios.Serv_productos;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class Seim_productos implements Serv_productos{
	@Autowired
	Repo_productos sp;
	
	@Override
	public List<Capsula_producto> listar() {
		
		return sp.findByEstado(1);
	}

	@Override
	public Capsula_producto buscarProducto(int codigo) {
		
		return sp.findById(codigo).orElse(null);
	}

	@Override
	public void eliminarProducto(Capsula_producto obj) {
		Capsula_producto cap = sp.findById(obj.getIdprod()).orElse(null);
		cap.setEstado(0);
		sp.save(cap);
	}

	@Override
	public void modificarProducto(Capsula_producto obj) {
		Capsula_producto cap = sp.findById(obj.getIdprod()).orElse(null);
		cap.setDescripcion(obj.getDescripcion());
		cap.setPrecio(obj.getPrecio());
		cap.setProveedor(obj.getProveedor());
		cap.setStock_max(obj.getStock_max());
		cap.setStock_min(obj.getStock_min());
		cap.setTipo(obj.getTipo());
		sp.save(cap);
	}

	@Override
	public void crearProducto(Capsula_producto obj) {
		sp.save(obj);
	}

	@Override
	public JasperPrint exportReport(String repor) throws FileNotFoundException, JRException {
		
		List<Capsula_producto>listadoP = sp.findByEstado(1);
		File archivo = ResourceUtils.getFile(repor);
		JasperReport report = JasperCompileManager.compileReport(archivo.getAbsolutePath());
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(listadoP);
		Map<String,Object> parametros = new HashMap<>();
		JasperPrint print = JasperFillManager.fillReport(report, parametros,ds);
		
		return print;
		
	}

	
	
}
