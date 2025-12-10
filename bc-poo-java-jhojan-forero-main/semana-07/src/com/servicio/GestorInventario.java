package com.libreria.servicio;

import com.libreria.modelo.Producto;
import com.libreria.excepciones.ProductoAgotadoException;
import com.libreria.excepciones.ProductoNoEncontradoException;

import java.util.HashMap;

public class GestorInventario {

    private HashMap<String, Producto> inventario = new HashMap<>();

    public void agregarProducto(Producto p) {
        inventario.put(p.getCodigo(), p);
    }

    public Producto buscarProducto(String codigo) throws ProductoNoEncontradoException {
        if (!inventario.containsKey(codigo)) {
            throw new ProductoNoEncontradoException("No existe el producto con código: " + codigo);
        }
        return inventario.get(codigo);
    }

    public void vender(String codigo) throws ProductoAgotadoException, ProductoNoEncontradoException {
        Producto p = buscarProducto(codigo);

        if (p.getStock() <= 0) {
            throw new ProductoAgotadoException("Stock agotado para el producto: " + codigo);
        }

        p.reducirStock();
    }
}
