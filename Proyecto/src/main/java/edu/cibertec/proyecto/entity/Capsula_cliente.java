package edu.cibertec.proyecto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="tb_clientes")
public class Capsula_cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcliente;
	private String rucdni;
	@NotEmpty
	private String razonsocial;
	private String direccion;
	private String celular;
	private int estado;
	
	
	
	
	
	
	public Capsula_cliente() {
		
	}
	
	public Capsula_cliente(int idcliente, String rucdni, String razonsocial, String direccion, String celular,
			int estado) {
		
		this.idcliente = idcliente;
		this.rucdni = rucdni;
		this.razonsocial = razonsocial;
		this.direccion = direccion;
		this.celular = celular;
		this.estado = estado;
	}
	
	
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public String getRucdni() {
		return rucdni;
	}
	public void setRucdni(String rucdni) {
		this.rucdni = rucdni;
	}
	public String getRazonsocial() {
		return razonsocial;
	}
	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
	
}
