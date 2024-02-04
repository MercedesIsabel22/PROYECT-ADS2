package edu.cibertec.proyecto.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="tb_number")
public class CapsulaNumber {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idnumber;
	private String prefij;
	private int numeracion;

	public String codigoconPrefijo() {
		String cod = getPrefij() + getNumeracion();
		return cod;
	}
	}
