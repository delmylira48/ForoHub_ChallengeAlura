package com.delmylira48.foroHub.ForoHub.domain.manejousuarios.perfil;

import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.perfil.roles.Roles;

public record PerfilDTO(
        Long id,
        Roles rol
) {
    public PerfilDTO(Perfil perfil) {
        this(perfil.getId(), perfil.getRol());
    }

}
