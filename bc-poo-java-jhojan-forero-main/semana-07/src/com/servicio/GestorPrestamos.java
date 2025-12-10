package com.servicio;

import com.libreria.interfaces.Prestable;
import com.libreria.excepciones.ProductoNoEncontradoException;
import com.libreria.modelo.Producto;

import java.util.HashMap;

public class GestorPrestamos {

    private HashMap<String, Prestable> prestables = new HashMap<>();

    public void registrarPrestable(Producto p) {
        if (p instanceof Prestable prestable) {
            prestables.put(p.getCodigo(), prestable);
        }
    }

    public void prestar(String codigo) throws ProductoNoEncontradoException {
        if (!prestables.containsKey(codigo)) {
            throw new ProductoNoEncontradoException("Este producto no es prestable: " + codigo);
        }

        prestables.get(codigo).prestar();
    }

    public void devolver(String codigo) throws ProductoNoEncontradoException {
        if (!prestables.containsKey(codigo)) {
            throw new ProductoNoEncontradoException("Este producto no es prestable: " + codigo);
        }

        prestables.get(codigo).devolver();
    }
}
