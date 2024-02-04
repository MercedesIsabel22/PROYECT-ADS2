package edu.cibertec.proyecto.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_tipoproductos")
public class CapsulaTipoProducto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtipo;
	private String descripcion;
}
