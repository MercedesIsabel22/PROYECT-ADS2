package edu.cibertec.proyecto.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="tb_ventas")
public class CapsulaVenta implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

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
