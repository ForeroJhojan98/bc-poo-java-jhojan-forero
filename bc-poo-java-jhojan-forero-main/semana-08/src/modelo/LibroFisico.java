package com.libreria.modelo;

import com.modelo.Producto;

public class LibroFisico extends Producto {

    private int paginas;

    public LibroFisico(String codigo, String titulo, double precio, int paginas) {
        super(codigo, titulo, precio, "LibroFisico");
        this.paginas = paginas;
    }

    public int getPaginas() { return paginas; }
}
