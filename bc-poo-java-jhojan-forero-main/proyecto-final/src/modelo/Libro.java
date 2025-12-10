package com.libreria.modelo;

public class Libro extends Publicacion {
    private String genero;

    public Libro(String codigo, String titulo, double precio, int anio, String genero) {
        super(codigo, titulo, precio, anio);
        this.genero = genero;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Libro: " + getTitulo() + " | Genero: " + genero);
    }
}
