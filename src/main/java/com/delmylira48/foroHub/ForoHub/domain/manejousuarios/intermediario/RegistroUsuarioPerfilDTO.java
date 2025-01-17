package com.delmylira48.foroHub.ForoHub.domain.manejousuarios.intermediario;

import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.perfil.PerfilDTO;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario.UsuarioDTO;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record RegistroUsuarioPerfilDTO(
        List<PerfilDTO> perfiles,
        @NotNull
        UsuarioDTO usuario
) {
}
