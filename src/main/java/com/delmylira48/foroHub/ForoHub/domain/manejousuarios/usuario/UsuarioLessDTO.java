package com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario;

import java.util.Optional;

public record UsuarioLessDTO(
        Long id,
        String nombre,
        String correo
) {
    public UsuarioLessDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getContrasena());
    }
}
