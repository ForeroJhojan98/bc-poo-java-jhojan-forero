package com.libreria.gestor;

import com.modelo.Producto;
import com.libreria.excepciones.ProductoNoEncontradoException;
import com.libreria.excepciones.ProductoYaExisteException;

import java.util.*;

public class GestorInventario {

    private List<Producto> inventario = new ArrayList<>();

    private Map<String, Producto> productosPorCodigo = new HashMap<>();

    private Map<String, List<Producto>> productosPorTipo = new HashMap<>();

    // CRUD
    public void agregar(Producto p) {
        if (productosPorCodigo.containsKey(p.getCodigo())) {
            throw new ProductoYaExisteException("Ya existe producto con código: " + p.getCodigo());
        }

        inventario.add(p);
        productosPorCodigo.put(p.getCodigo(), p);

        productosPorTipo
                .computeIfAbsent(p.getTipo(), t -> new ArrayList<>())
                .add(p);
    }

    public Producto buscar(String codigo) {
        return productosPorCodigo.get(codigo);
    }

    public Producto eliminar(String codigo) {
        if (!productosPorCodigo.containsKey(codigo)) {
            throw new ProductoNoEncontradoException("No existe producto con código: " + codigo);
        }

        Producto p = productosPorCodigo.remove(codigo);
        inventario.remove(p);
        productosPorTipo.get(p.getTipo()).remove(p);

        return p;
    }

    public List<Producto> listar() {
        return new ArrayList<>(inventario);
    }

    public int cantidad() {
        return inventario.size();
    }

    // FILTROS
    public List<Producto> filtrarPorPrecio(double min, double max) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : inventario) {
            if (p.getPrecio() >= min && p.getPrecio() <= max) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    // ESTADÍSTICAS
    public double totalInventario() {
        double total = 0;
        for (Producto p : inventario) {
            total += p.getPrecio();
        }
        return total;
    }

    public double promedioPrecio() {
        if (inventario.isEmpty()) return 0;
        return totalInventario() / inventario.size();
    }

    public Producto productoMasCaro() {
        if (inventario.isEmpty()) return null;

        Producto max = inventario.get(0);
        for (Producto p : inventario) {
            if (p.getPrecio() > max.getPrecio()) {
                max = p;
            }
        }
        return max;
    }

    public Map<String, Integer> conteoPorTipo() {
        Map<String, Integer> conteo = new HashMap<>();

        for (Producto p : inventario) {
            conteo.put(
                    p.getTipo(),
                    conteo.getOrDefault(p.getTipo(), 0) + 1
            );
        }
        return conteo;
    }
}
