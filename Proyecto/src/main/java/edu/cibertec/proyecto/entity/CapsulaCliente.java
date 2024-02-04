package edu.cibertec.proyecto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name="tb_clientes")
public class CapsulaCliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcliente;
	private String rucdni;
	@NotEmpty
	private String razonsocial;
	private String direccion;
	private String celular;
	private int estado;
}
