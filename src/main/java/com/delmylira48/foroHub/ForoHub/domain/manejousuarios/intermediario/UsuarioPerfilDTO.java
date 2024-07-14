package com.delmylira48.foroHub.ForoHub.domain.manejousuarios.intermediario;

import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.perfil.PerfilDTO;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario.UsuarioDTO;


public record UsuarioPerfilDTO(Long id,
                               PerfilDTO perfiles,
                               UsuarioDTO usuario) {
}
