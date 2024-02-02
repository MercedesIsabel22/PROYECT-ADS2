package edu.cibertec.proyecto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_proveedor")
public class Capsula_proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idproveedor;
	private String rucdni;
	private String razonsocial;
	private String celular;
	private String correo;
	private int estado;
	
	
	public Capsula_proveedor(int idproveedor, String rucdni, String razonsocial, String celular, String correo,
			int estado) {
		
		this.idproveedor = idproveedor;
		this.rucdni = rucdni;
		this.razonsocial = razonsocial;
		this.celular = celular;
		this.correo = correo;
		this.estado = estado;
	}
	public Capsula_proveedor() {
		
	}
	
	
	
	public int getIdproveedor() {
		return idproveedor;
	}
	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
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
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
}
