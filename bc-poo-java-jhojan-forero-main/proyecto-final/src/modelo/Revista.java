package com.libreria.modelo;

public class Revista extends Publicacion {
    private int edicion;

    public Revista(String codigo, String titulo, double precio, int anio, int edicion) {
        super(codigo, titulo, precio, anio);
        this.edicion = edicion;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Revista: " + getTitulo() + " | Edición: " + edicion);
    }
}
