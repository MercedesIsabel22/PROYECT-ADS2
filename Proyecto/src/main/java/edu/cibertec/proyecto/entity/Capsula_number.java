package edu.cibertec.proyecto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_number")
public class Capsula_number {
	@Id
	private int idnumber;
	private String prefij;
	private int numeracion;
	
	public Capsula_number() {
		
	}
	
	public Capsula_number(int idnumber, String prefij, int numeracion) {
		
		this.idnumber = idnumber;
		this.prefij = prefij;
		this.numeracion = numeracion;
	}
	
	
	public String codigoconPrefijo() {
		String cod = getPrefij() + getNumeracion();
		return cod;
	}
	
	
	public int codigosinPrefijo() {
		return idnumber;
	}
	public void setIdnumber(int idnumber) {
		this.idnumber = idnumber;
	}
	public String getPrefij() {
		return prefij;
	}
	public void setPrefij(String prefij) {
		this.prefij = prefij;
	}
	public int getNumeracion() {
		return numeracion;
	}
	public void setNumeracion(int numeracion) {
		this.numeracion = numeracion;
	}
	
	
	
	
}
