package edu.cibertec.proyecto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_usuarios")
public class Capsula_usuario {
@Id
private int idusuario;
private String nombre;
private String usuario;
private String clave;
private int estado;

public Capsula_usuario() {
	
}


public Capsula_usuario(int idusuario, String nombre, String usuario, String clave, int estado) {
	this.idusuario = idusuario;
	this.nombre = nombre;
	this.usuario = usuario;
	this.clave = clave;
	this.estado = estado;
}


public int getIdusuario() {
	return idusuario;
}


public void setIdusuario(int idusuario) {
	this.idusuario = idusuario;
}


public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}


public String getUsuario() {
	return usuario;
}


public void setUsuario(String usuario) {
	this.usuario = usuario;
}


public String getClave() {
	return clave;
}


public void setClave(String clave) {
	this.clave = clave;
}


public int getEstado() {
	return estado;
}


public void setEstado(int estado) {
	this.estado = estado;
}



}
