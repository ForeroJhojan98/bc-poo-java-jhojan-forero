package com.libreria.excepciones;

/**
 * Excepción lanzada cuando un producto no tiene stock.
 */
public class ProductoAgotadoException extends Exception {

    public ProductoAgotadoException(String mensaje) {
        super(mensaje);
    }

    public ProductoAgotadoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
