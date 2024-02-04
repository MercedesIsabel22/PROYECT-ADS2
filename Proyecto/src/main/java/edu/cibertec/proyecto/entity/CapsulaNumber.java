package edu.cibertec.proyecto.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tb_number")
public class CapsulaNumber implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

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
