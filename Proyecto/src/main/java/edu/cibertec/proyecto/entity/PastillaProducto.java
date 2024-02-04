package edu.cibertec.proyecto.entity;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PastillaProducto implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	private Long idProducto;
	private String name;
	private String idCliente;
	@NotNull
	private int cantidad;
	@NotNull
	private Double costo;
}
