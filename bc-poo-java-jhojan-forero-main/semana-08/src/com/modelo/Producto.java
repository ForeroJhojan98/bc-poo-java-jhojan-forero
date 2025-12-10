package com.modelo;

public abstract class Producto {

    protected String codigo;
    protected String titulo;
    protected double precio;
    protected String tipo; // LibroDigital, LibroFisico, Revista

    public Producto(String codigo, String titulo, double precio, String tipo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public double getPrecio() { return precio; }
    public String getTipo() { return tipo; }

    @Override
    public String toString() {
        return tipo + " { " +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", precio=" + precio +
                " }";
    }
}
