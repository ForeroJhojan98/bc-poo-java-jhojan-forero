package com.libreria;

import com.libreria.modelo.*;
import com.libreria.servicio.*;
import com.libreria.excepciones.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Sistema Librería - Semana 07 ===\n");

        GestorInventario inventario = new GestorInventario();
        GestorPrestamos prestamos = new GestorPrestamos();

        Producto libro1 = new LibroFisico("L001", "El Quijote", 30000, 2);
        Producto digital1 = new LibroDigital("D001", "Java Básico", 15000, 5, 12);
        Producto revista1 = new Revista("R001", "Ciencia Hoy", 8000, 1, 52);

        inventario.agregarProducto(libro1);
        inventario.agregarProducto(digital1);
        inventario.agregarProducto(revista1);

        prestamos.registrarPrestable(libro1);

        // === Caso 1: Venta exitosa ===
        System.out.println("\n--- Caso 1: Venta Exitosa ---");
        try {
            inventario.vender("R001");
            System.out.println("Venta realizada correctamente");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // === Caso 2: Stock agotado ===
        System.out.println("\n--- Caso 2: Stock Agotado ---");
        try {
            inventario.vender("R001");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // === Caso 3: Producto no existe ===
        System.out.println("\n--- Caso 3: Producto Inexistente ---");
        try {
            inventario.buscarProducto("XYZ");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // === Caso 4: Préstamo ===
        System.out.println("\n--- Caso 4: Préstamo ---");
        try {
            prestamos.prestar("L001");
            System.out.println("Libro prestado con éxito");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // === Caso 5: finally ejemplo ===
        System.out.println("\n--- Caso 5: Finally ---");
        try {
            throw new Exception("Error simulado");
        } catch (Exception e) {
            System.err.println("Ocurrió un error: " + e.getMessage());
        } finally {
            System.out.println("Bloque finally ejecutado correctamente");
        }
    }
}
