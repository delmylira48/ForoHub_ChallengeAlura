package com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario;


public record UsuarioDTO(
         Long id,
         String nombre,
         String correo,
         String contrasena
) {
    public UsuarioDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getCorreo(), usuario.getContrasena());
    }
}
