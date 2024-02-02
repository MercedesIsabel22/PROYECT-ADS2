package edu.cibertec.proyecto.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Pastilla_Producto {
	private int idProducto;
	private String name;
	private String idCliente;
	@NotNull
	private int cantidad;
	@NotNull
	private Double costo;
	
	public Pastilla_Producto() {
		
	}
	
	public Pastilla_Producto(int idProducto,String name, String idCliente, int cantidad, Double costo) {
		
		this.idProducto = idProducto;
		this.name=name;
		this.idCliente = idCliente;	
		this.cantidad = cantidad;
		this.costo = costo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Double getCosto() {
		return costo;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}
	
	
}
