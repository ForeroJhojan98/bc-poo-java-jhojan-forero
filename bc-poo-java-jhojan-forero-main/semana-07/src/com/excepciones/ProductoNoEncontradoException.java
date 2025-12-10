package com.libreria.excepciones;

/**
 * Excepción lanzada cuando un producto no existe en inventario.
 */
public class ProductoNoEncontradoException extends Exception {

    public ProductoNoEncontradoException(String mensaje) {
        super(mensaje);
    }

    public ProductoNoEncontradoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
