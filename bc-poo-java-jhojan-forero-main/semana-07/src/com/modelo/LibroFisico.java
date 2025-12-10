package com.libreria.modelo;

import com.libreria.interfaces.Prestable;
import com.libreria.interfaces.Vendible;

public class LibroFisico extends Producto implements Vendible, Prestable {

    private boolean prestado = false;

    public LibroFisico(String codigo, String titulo, double precio, int stock) {
        super(codigo, titulo, precio, stock);
    }

    @Override
    public double calcularPrecioVenta() {
        return precio * 1.10;
    }

    @Override
    public void prestar() {
        if (prestado) {
            throw new IllegalStateException("El libro ya está prestado");
        }
        prestado = true;
    }

    @Override
    public void devolver() {
        prestado = false;
    }
}
