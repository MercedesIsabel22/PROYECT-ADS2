package edu.cibertec.proyecto.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PastillaProducto {
	private Long idProducto;
	private String name;
	private String idCliente;
	@NotNull
	private int cantidad;
	@NotNull
	private Double costo;
}
