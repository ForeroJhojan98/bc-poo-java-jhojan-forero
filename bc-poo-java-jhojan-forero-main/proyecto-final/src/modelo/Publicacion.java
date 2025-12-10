
package com.libreria.modelo;

public abstract class Publicacion {
    private String codigo;
    private String titulo;
    private double precio;
    private int anio;

    public Publicacion(String codigo, String titulo, double precio, int anio) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.precio = precio;
        this.anio = anio;
    }

    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public double getPrecio() { return precio; }
    public int getAnio() { return anio; }

    public void setPrecio(double precio) { this.precio = precio; }

    public abstract void mostrarInfo();
}
