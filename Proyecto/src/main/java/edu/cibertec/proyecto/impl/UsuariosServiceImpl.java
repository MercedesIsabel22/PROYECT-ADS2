package edu.cibertec.proyecto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.repositories.IUsuariosRepository;
import edu.cibertec.proyecto.services.IUsuariosService;
@Service
public class UsuariosServiceImpl implements IUsuariosService {
	@Autowired
	IUsuariosRepository ru;
	
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
