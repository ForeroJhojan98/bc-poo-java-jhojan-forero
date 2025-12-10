package com.libreria;

import com.libreria.modelo.*;
import com.libreria.servicio.*;

public class Main {
    public static void main(String[] args) {

        LibreriaService service = new LibreriaService();

        service.agregar(new Libro("001", "El Hobbit", 45.0, 1937, "Fantasia"));
        service.agregar(new Revista("010", "Science", 25.0, 2024, 58));

        for (var p : service.listar()) p.mostrarInfo();
    }