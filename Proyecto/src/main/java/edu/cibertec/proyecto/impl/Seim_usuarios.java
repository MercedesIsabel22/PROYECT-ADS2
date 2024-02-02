package edu.cibertec.proyecto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.repositorios.Repo_usuarios;
import edu.cibertec.proyecto.servicios.Serv_usuarios;
@Service
public class Seim_usuarios implements Serv_usuarios{
	@Autowired
	Repo_usuarios ru;
	
	@Override
	public boolean validarLogin(String User, String Password) {
		
		boolean valor = false;
		int result = ru.findByUsuarioAndClave(User, Password).size();
		if (result > 0) {
			valor=true;
		}
		return valor;
	}

}
