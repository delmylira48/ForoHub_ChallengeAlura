package com.delmylira48.foroHub.ForoHub.domain.topico;

import com.delmylira48.foroHub.ForoHub.domain.curso.CursoDTO;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario.UsuarioDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicoDTO(
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String contenido,
        @NotNull
        UsuarioDTO autor,
        @NotNull
        CursoDTO curso) {
    public TopicoDTO(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getContenido(), new UsuarioDTO(topico.getAutor()), new CursoDTO(topico.getCurso()));
    }
}
