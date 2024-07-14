package com.delmylira48.foroHub.ForoHub.infra.errores;

import org.springframework.validation.FieldError;

public record ErroresDTO(String campo,
                         String error) {
    public ErroresDTO(FieldError errores){
        this(errores.getField(), errores.getDefaultMessage());
    }
}
