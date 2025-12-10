package com.libreria.servicio;

import com.libreria.modelo.Publicacion;
import java.util.*;

public class EstadisticasService {

    public double totalVentas(List<Publicacion> lista) {
        double total = 0;
        for (Publicacion p : lista) total += p.getPrecio();
        return total;
    }

    public double promedio(List<Publicacion> lista) {
        return totalVentas(lista) / lista.size();
    }
}
