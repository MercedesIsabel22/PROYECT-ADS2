package edu.cibertec.proyecto.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name = "tb_operaciones")
public class CapsulaOperacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long operaciones;
	private String proceso;
	private int tipo;
	@ManyToOne
	@JoinColumn(name = "producto")
	private CapsulaProducto producto;
	private int cantidad;
	private Double preciocpa;
	private Date fechacpa;
	private int estado;
}
