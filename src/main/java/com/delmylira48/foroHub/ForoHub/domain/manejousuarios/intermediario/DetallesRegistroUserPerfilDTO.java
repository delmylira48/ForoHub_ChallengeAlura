package com.delmylira48.foroHub.ForoHub.domain.manejousuarios.intermediario;

import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.perfil.Perfil;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.perfil.PerfilDTO;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario.Usuario;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario.UsuarioDTO;

import java.time.LocalDateTime;
import java.util.List;

public record DetallesRegistroUserPerfilDTO(
        List<PerfilDTO> perfiles,
        UsuarioDTO usuario
) {
    // Constructor adicional
    public DetallesRegistroUserPerfilDTO(UsuarioDTO usuario, List<PerfilDTO> perfiles) {
        this(perfiles, usuario); // Llama al constructor principal del record
    }
}

