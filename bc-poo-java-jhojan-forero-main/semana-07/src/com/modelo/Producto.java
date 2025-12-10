package com.libreria.modelo;

public abstract class Producto {
    protected String codigo;
    protected String titulo;
    protected double precio;
    protected int stock;

    public Producto(String codigo, String titulo, double precio, int stock) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código no puede estar vacío");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }

        this.codigo = codigo;
        this.titulo = titulo;
        this.precio = precio;
        this.stock = stock;
    }

    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }

    public void reducirStock() {
        if (stock <= 0) {
            throw new IllegalStateException("No hay stock disponible");
        }
        stock--;
    }

    @Override
    public String toString() {
        return titulo + " (" + codigo + ") - $" + precio + " | Stock: " + stock;
    }
}
