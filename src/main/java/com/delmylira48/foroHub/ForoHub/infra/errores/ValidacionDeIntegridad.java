package com.delmylira48.foroHub.ForoHub.infra.errores;

public class ValidacionDeIntegridad extends RuntimeException {
    public ValidacionDeIntegridad(String noEsta) {
        super(noEsta);
    }
}
