package com.libreria.modelo;

import com.modelo.Producto;

public class Revista extends Producto {

    private int numeroEdicion;

    public Revista(String codigo, String titulo, double precio, int numeroEdicion) {
        super(codigo, titulo, precio, "Revista");
        this.numeroEdicion = numeroEdicion;
    }

    public int getNumeroEdicion() { return numeroEdicion; }
}
