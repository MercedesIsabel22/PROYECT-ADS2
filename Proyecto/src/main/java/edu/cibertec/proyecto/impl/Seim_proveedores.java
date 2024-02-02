package edu.cibertec.proyecto.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.Capsula_proveedor;
import edu.cibertec.proyecto.repositorios.Repo_proveedores;
import edu.cibertec.proyecto.servicios.Serv_proveedores;

@Service
public class Seim_proveedores implements Serv_proveedores {
	@Autowired
	Repo_proveedores rp;
	
	@Override
	public List<Capsula_proveedor> listar() {
		
		return rp.findByEstado(1);
	}

	@Override
	public Capsula_proveedor buscarProveedor(int codigo) {
		
		return rp.findById(codigo).orElse(null);
	}

	@Override
	public void eliminarProveedor(Capsula_proveedor obj) {
		Capsula_proveedor prov = rp.findById(obj.getIdproveedor()).orElse(null);
		prov.setEstado(0);
		rp.save(prov);
		
	}

	@Override
	public void modificarProveedor(Capsula_proveedor obj) {
		Capsula_proveedor prov = rp.findById(obj.getIdproveedor()).orElse(null);
		prov.setIdproveedor(obj.getIdproveedor());
		prov.setCelular(obj.getCelular());
		prov.setCorreo(obj.getCorreo());
		prov.setRazonsocial(obj.getRazonsocial());
		prov.setRucdni(obj.getRucdni());
		prov.setEstado(1);
		rp.save(prov);
	}

	@Override
	public void crearProveedor(Capsula_proveedor obj) {
		rp.save(obj);
		
	}

}
