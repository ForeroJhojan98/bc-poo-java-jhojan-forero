package com.libreria.excepciones;

public class ProductoYaExisteException extends RuntimeException {
    public ProductoYaExisteException(String mensaje) {
        super(mensaje);
    }
}

