package edu.cibertec.proyecto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_tipoproductos")
public class Capsula_tipoproducto {
	@Id
	private int idtipo;
	private String descripcion;
	
	public Capsula_tipoproducto() {

	}
	
	public Capsula_tipoproducto(int idtipo, String descripcion) {
		this.idtipo = idtipo;
		this.descripcion = descripcion;
	}
	
	public int getIdtipo() {
		return idtipo;
	}
	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
