package edu.cibertec.proyecto.entity;

import java.util.Date;

import org.springframework.aot.generate.GenerationContext;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Table(name = "tb_operaciones")
public class Capsula_operacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int operaciones;
	private String proceso;
	private int tipo;
	@ManyToOne
	@JoinColumn(name = "producto")
	private Capsula_producto producto;
	private int cantidad;
	private Double preciocpa;
	private Date fechacpa;
	private int estado;
	
	
	
	public Capsula_operacion() {
		
	}
	
	
	
	public Capsula_operacion(String proceso, int tipo, Capsula_producto producto, int cantidad,
			Double precio, Date fechacpa, int estado) {
		this.operaciones = operaciones;
		this.proceso = proceso;
		this.tipo = tipo;
		this.producto = producto;
		this.cantidad = cantidad;
		this.preciocpa = precio;
		this.fechacpa = fechacpa;
		this.estado = estado;
	}



	public int getOperaciones() {
		return operaciones;
	}
	public void setOperaciones(int operaciones) {
		this.operaciones = operaciones;
	}
	public String getProceso() {
		return proceso;
	}
	public void setProceso(String proceso) {
		this.proceso = proceso;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public Capsula_producto getProducto() {
		return producto;
	}
	public void setProducto(Capsula_producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return preciocpa;
	}
	public void setPrecio(Double precio) {
		this.preciocpa = precio;
	}
	public Date getFechacpa() {
		return fechacpa;
	}
	public void setFechacpa(Date fechacpa) {
		this.fechacpa = fechacpa;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
}
