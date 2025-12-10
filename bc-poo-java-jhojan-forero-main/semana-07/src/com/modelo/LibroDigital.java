package com.libreria.modelo;

import com.libreria.interfaces.Vendible;

public class LibroDigital extends Producto implements Vendible {

    private double tamanioMB;

    public LibroDigital(String codigo, String titulo, double precio, int stock, double tamanioMB) {
        super(codigo, titulo, precio, stock);

        if (tamanioMB <= 0) {
            throw new IllegalArgumentException("El tamaño debe ser mayor a 0");
        }
        this.tamanioMB = tamanioMB;
    }

    @Override
    public double calcularPrecioVenta() {
        return precio;
    }
}
