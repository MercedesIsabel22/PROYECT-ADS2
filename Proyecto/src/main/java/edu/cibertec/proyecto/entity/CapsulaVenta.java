package edu.cibertec.proyecto.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

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
	private String ventas;
	@ManyToOne
	@JoinColumn(name = "cliente")
	private CapsulaCliente cliente;
	private Double precio;
	private LocalDate fecha;
	private int estado;
}
