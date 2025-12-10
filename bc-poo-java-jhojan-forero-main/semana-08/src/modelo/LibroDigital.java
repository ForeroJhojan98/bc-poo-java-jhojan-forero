package com.libreria.modelo;

import com.modelo.Producto;

public class LibroDigital extends Producto {

    private double tamanoMB;

    public LibroDigital(String codigo, String titulo, double precio, double tamanoMB) {
        super(codigo, titulo, precio, "LibroDigital");
        this.tamanoMB = tamanoMB;
    }

    public double getTamanoMB() { return tamanoMB; }
}
