package edu.cibertec.proyecto.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.cibertec.proyecto.entity.CapsulaProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import edu.cibertec.proyecto.repositories.ProductosRepository;
import edu.cibertec.proyecto.services.ProductosService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ProductosServiceImpl implements ProductosService {
	@Autowired
    ProductosRepository repository;
	
	@Override
	public List<CapsulaProducto> listar() {
		
		return repository.findByEstado(1);
	}

	@Override
	public CapsulaProducto buscarProducto(Long codigo) {
		
		return repository.findById(codigo).orElse(null);
	}

	@Override
	public void eliminarProducto(CapsulaProducto obj) {
		CapsulaProducto cap = repository.findById(obj.getIdprod()).orElse(null);
		cap.setEstado(0);
		repository.save(cap);
	}

	@Override
	public void modificarProducto(CapsulaProducto obj) {
		CapsulaProducto cap = repository.findById(obj.getIdprod()).orElse(null);
		cap.setDescripcion(obj.getDescripcion());
		cap.setPrecio(obj.getPrecio());
		cap.setProveedor(obj.getProveedor());
		cap.setStock_max(obj.getStock_max());
		cap.setStock_min(obj.getStock_min());
		cap.setTipo(obj.getTipo());
		repository.save(cap);
	}

	@Override
	public void crearProducto(CapsulaProducto obj) {
		repository.save(obj);
	}

	@Override
	public JasperPrint exportReport(String repor) throws FileNotFoundException, JRException {
		
		List<CapsulaProducto>listadoP = repository.findByEstado(1);
		File archivo = ResourceUtils.getFile(repor);
		JasperReport report = JasperCompileManager.compileReport(archivo.getAbsolutePath());
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(listadoP);
		Map<String,Object> parametros = new HashMap<>();
		JasperPrint print = JasperFillManager.fillReport(report, parametros,ds);
		
		return print;
		
	}
}
