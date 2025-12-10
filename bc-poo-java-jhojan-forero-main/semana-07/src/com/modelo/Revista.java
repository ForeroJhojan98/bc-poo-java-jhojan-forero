package com.libreria.modelo;

import com.libreria.interfaces.Vendible;

public class Revista extends Producto implements Vendible {

    private int numeroEdicion;

    public Revista(String codigo, String titulo, double precio, int stock, int numeroEdicion) {
        super(codigo, titulo, precio, stock);

        if (numeroEdicion <= 0) {
            throw new IllegalArgumentException("Número de edición inválido");
        }

        this.numeroEdicion = numeroEdicion;
    }

    @Override
    public double calcularPrecioVenta() {
        return precio;
    }
}
