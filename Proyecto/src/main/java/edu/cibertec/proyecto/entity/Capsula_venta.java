package edu.cibertec.proyecto.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_ventas")
public class Capsula_venta {
	
	@Id
	private String ventas;
	@ManyToOne
	@JoinColumn(name = "cliente")
	private Capsula_cliente cliente;
	private Double precio;
	private Date fecha;
	private int estado;
	
	
	public Capsula_venta() {
		
	}
	public Capsula_venta(String ventas, Capsula_cliente cliente, Double precio, Date fecha, int estado) {
		
		this.ventas = ventas;
		this.cliente = cliente;
		this.precio = precio;
		this.fecha = fecha;
		this.estado = estado;
	}
	
	public String getVentas() {
		return ventas;
	}
	public void setVentas(String ventas) {
		this.ventas = ventas;
	}
	public Capsula_cliente getCliente() {
		return cliente;
	}
	public void setCliente(Capsula_cliente cliente) {
		this.cliente = cliente;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
	
}
