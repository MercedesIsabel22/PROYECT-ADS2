package edu.cibertec.proyecto.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name="tb_ventas")
public class CapsulaVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String ventas;
	@ManyToOne
	@JoinColumn(name = "cliente")
	private CapsulaCliente cliente;
	private Double precio;
	private Date fecha;
	private int estado;
}
