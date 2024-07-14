package com.delmylira48.foroHub.ForoHub.infra.errores;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadoDeError {
    @ExceptionHandler(EntityNotFoundException.class) //atrapa la excepción no encontrada que aparece en la terminal
    public ResponseEntity tratarError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarBadRequest(MethodArgumentNotValidException methodArgumentNotValidException){
        var errores = methodArgumentNotValidException.getFieldErrors().stream().map(ErroresDTO::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity errorValidaciones(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(ValidacionDeIntegridad.class)
    public ResponseEntity errorValidacionesDeNegocio(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
