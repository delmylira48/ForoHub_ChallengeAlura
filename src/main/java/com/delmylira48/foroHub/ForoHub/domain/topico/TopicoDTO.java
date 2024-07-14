package com.delmylira48.foroHub.ForoHub.domain.topico;

import com.delmylira48.foroHub.ForoHub.domain.curso.CursoDTO;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario.UsuarioDTO;

import java.time.LocalDateTime;

public record TopicoDTO(
        Long id,
        String titulo,
        String contenido,
        UsuarioDTO autor,
        CursoDTO curso) {
    public TopicoDTO(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getContenido(), new UsuarioDTO(topico.getAutor()), new CursoDTO(topico.getCurso()));
    }
}
