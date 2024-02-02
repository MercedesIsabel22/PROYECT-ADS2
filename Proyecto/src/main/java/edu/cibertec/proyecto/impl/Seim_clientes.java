package edu.cibertec.proyecto.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.Capsula_cliente;
import edu.cibertec.proyecto.repositorios.Repo_clientes;
import edu.cibertec.proyecto.servicios.Serv_clientes;
@Service
public class Seim_clientes implements Serv_clientes{
	@Autowired
	Repo_clientes rc;
	
	@Override
	public List<Capsula_cliente> listar() {
		return rc.findByEstado(1);
	}

	@Override
	public Capsula_cliente buscarCliente(int codigo) {
		return rc.findById(codigo).orElse(null);
	}

	@Override
	public void eliminarCliente(Capsula_cliente obj) {
		Capsula_cliente cli = rc.findById(obj.getIdcliente()).orElse(null);
		cli.setEstado(0);
		rc.save(cli);
	}

	@Override
	public void modificarCliente(Capsula_cliente obj) {
		Capsula_cliente cli = rc.findById(obj.getIdcliente()).orElse(null);
		cli.setIdcliente(obj.getIdcliente());
		cli.setCelular(obj.getCelular());
		cli.setDireccion(obj.getDireccion());
		cli.setRazonsocial(obj.getRazonsocial());
		cli.setRucdni(obj.getRucdni());
		cli.setEstado(1);
		rc.save(cli);
	}

	@Override
	public void crearCliente(Capsula_cliente obj) {
		rc.save(obj);
	}

}
