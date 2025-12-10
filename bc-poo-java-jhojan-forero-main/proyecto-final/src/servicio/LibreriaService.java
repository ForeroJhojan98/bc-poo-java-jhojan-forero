package com.libreria.servicio;

import com.libreria.modelo.Publicacion;
import java.util.*;

public class LibreriaService {

    private Map<String, Publicacion> catalogo = new HashMap<>();
    private List<Publicacion> historial = new ArrayList<>();

    public void agregar(Publicacion p) {
        catalogo.put(p.getCodigo(), p);
        historial.add(p);
    }

    public Publicacion buscar(String codigo) {
        return catalogo.get(codigo);
    }

    public void eliminar(String codigo) {
        catalogo.remove(codigo);
    }

    public List<Publicacion> filtrarPorPrecio(double min, double max) {
        List<Publicacion> resultado = new ArrayList<>();
        for (Publicacion p : catalogo.values()) {
            if (p.getPrecio() >= min && p.getPrecio() <= max) resultado.add(p);
        }
        return resultado;
    }

    public Collection<Publicacion> listar() {
        return catalogo.values();
    }
}
