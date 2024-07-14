package com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario;


import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
         Long id,
         @NotBlank
         String nombre,
         @NotBlank
         String correo,
         @NotBlank
         String contrasena
) {
    public UsuarioDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getCorreo(), usuario.getContrasena());
    }
}
