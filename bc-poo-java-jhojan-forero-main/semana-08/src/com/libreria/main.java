package com.libreria;

import com.libreria.gestor.GestorInventario;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GestorInventario gestor = new GestorInventario();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== SISTEMA DE INVENTARIO DE LIBRERÍA ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Buscar por código");
            System.out.println("3. Listar productos");
            System.out.println("4. Filtrar por precio");
            System.out.println("5. Estadísticas");
            System.out.println("6. Eliminar producto");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    agregarProducto(gestor, sc);
                    break;
                case 2:
                    buscarProducto(gestor, sc);
                    break;
                case 3:
                    listar(gestor);
                    break;
                case 4:
                    filtrarPrecio(gestor, sc);
                    break;
                case 5:
                    estadisticas(gestor);
                    break;
                case 6:
                    eliminar(gestor, sc);
                    break;
            }

        } while (opcion != 0);
    }
