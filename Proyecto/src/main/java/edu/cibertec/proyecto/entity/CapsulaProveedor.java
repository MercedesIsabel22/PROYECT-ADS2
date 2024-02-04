package edu.cibertec.proyecto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="tb_proveedor")
public class CapsulaProveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idproveedor;
	private String rucdni;
	private String razonsocial;
	private String celular;
	private String correo;
	private int estado;
}
