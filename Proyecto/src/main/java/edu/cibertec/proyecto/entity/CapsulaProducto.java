package edu.cibertec.proyecto.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_productos")
public class CapsulaProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long idprod;
	@ManyToOne
	@JoinColumn(name = "tipo")
	private CapsulaTipoProducto tipo;
	
	private String descripcion;
	
	@Column(name="precio")
	private Double precio;
	private int stock_min;
	private int stock_max;
	@ManyToOne
	@JoinColumn(name = "proveedor")
	private CapsulaProveedor proveedor;
	private int estado;
	
	@OneToMany(mappedBy = "producto")
	List<CapsulaOperacion>lstCantidad;

	
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
}
