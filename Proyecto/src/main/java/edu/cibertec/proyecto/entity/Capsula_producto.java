package edu.cibertec.proyecto.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;


@Entity
@Table(name = "tb_productos")
public class Capsula_producto {
	@Id
	private int idprod;
	@ManyToOne
	@JoinColumn(name = "tipo")
	private Capsula_tipoproducto tipo;
	
	private String descripcion;
	
	@Column(name="precio")
	private Double precio;
	private int stock_min;
	private int stock_max;
	@ManyToOne
	@JoinColumn(name = "proveedor")
	private Capsula_proveedor proveedor;
	private int estado;
	
	@OneToMany(mappedBy = "producto")
	List<Capsula_operacion>lstCantidad;
	
	

	public Capsula_producto() {

	}

	
	public Capsula_producto(int idprod, Capsula_tipoproducto tipo, String descripcion, Double precio, int stock_min,
			int stock_max, Capsula_proveedor proveedor, int estado, List<Capsula_operacion> lstCantidad) {
		this.idprod = idprod;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock_min = stock_min;
		this.stock_max = stock_max;
		this.proveedor = proveedor;
		this.estado = estado;
		this.lstCantidad = lstCantidad;
	}

	
	public int getStock() {
		return lstCantidad.stream().mapToInt(o -> o.getCantidad()).sum();
	}
	
	public boolean getReponer() {
		int stk = getStock();
		boolean men = false;
		if (stk < getStock_min()) {
			men = true;
		}else {
			men = false;
		}
		return men;
	}
	
	public int getIdprod() {
		return idprod;
	}

	public void setIdprod(int idprod) {
		this.idprod = idprod;
	}

	public Capsula_tipoproducto getTipo() {
		return tipo;
	}
	
	public String getNameTipoproducto() {
		return getTipo().getDescripcion();
	}
	
	public void setTipo(Capsula_tipoproducto tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getStock_min() {
		return stock_min;
	}

	public void setStock_min(int stock_min) {
		this.stock_min = stock_min;
	}

	public int getStock_max() {
		return stock_max;
	}

	public void setStock_max(int stock_max) {
		this.stock_max = stock_max;
	}

	public Capsula_proveedor getProveedor() {
		return proveedor;
	}
	
	public String getNameproveedor() {
		return proveedor.getRazonsocial();
	}
	public void setProveedor(Capsula_proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public List<Capsula_operacion> getLstCantidad() {
		return lstCantidad;
	}

	public void setLstCantidad(List<Capsula_operacion> lstCantidad) {
		this.lstCantidad = lstCantidad;
	}
	
	
	
	
	
}
