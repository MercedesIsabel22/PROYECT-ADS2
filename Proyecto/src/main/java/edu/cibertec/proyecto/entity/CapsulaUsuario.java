package edu.cibertec.proyecto.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_usuarios")
public class CapsulaUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;
    private String nombre;
    private String usuario;
    private String clave;
    private int estado;
}
