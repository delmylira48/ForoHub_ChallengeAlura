package com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Email
    private String correo;

    private String contrasena;

    public Usuario(UsuarioDTO us) {
        this.nombre=us.nombre();
        this.correo=us.correo();
        this.contrasena=us.contrasena();
    }
}
