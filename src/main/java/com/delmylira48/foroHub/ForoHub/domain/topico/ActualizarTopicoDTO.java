package com.delmylira48.foroHub.ForoHub.domain.topico;

import jakarta.validation.Valid;

public record ActualizarTopicoDTO(@Valid Long id,
                                  String titulo,
                                  String contenido,
                                  Estatus status) {
}
