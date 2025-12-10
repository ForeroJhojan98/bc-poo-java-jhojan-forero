import java.util.ArrayList;

/**
 * PROGRAMA PRINCIPAL - Demostración completa de POLIMORFISMO
 * EJERCICIO 4: ArrayList polimórfico y demostración dinámica
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║           SEMANA 05 - POLIMORFISMO COMPLETO            ║");
        System.out.println("║              Librería 'Mundo del Libro'                ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        // ========== CREACIÓN DEL SISTEMA ==========
        SistemaPolimorfico sistema = new SistemaPolimorfico();

        // ========== CREACIÓN DE PRODUCTOS (DIFERENTES SUBCLASES) ==========
        System.out.println("=== 1. CREANDO PRODUCTOS DE DIFERENTES TIPOS ===");

        // Crear libros (Subclase 1)
        Libro libro1 = new Libro(
                "LIB-001", "Cien Años de Soledad", 45000.0, 15,
                "978-958-42-1234-5", "Gabriel García Márquez",
                "Sudamericana", 1967, "Realismo Mágico"
        );

        Libro libro2 = new Libro(
                "LIB-002", "El Principito", 32000.0, 8,
                "978-607-12-3456-7", "Antoine de Saint-Exupéry",
                "Salamandra", 1943, "Literatura Infantil"
        );

        Libro libro3 = new Libro(
                "LIB-003", "1984", 38000.0, 12,
                "978-84-9759-275-3", "George Orwell",
                "Debolsillo", 1949, "Ciencia Ficción"
        );

        // Crear productos de papelería (Subclase 2) - COMPORTAMIENTO DIFERENTE
        ProductoPapeleria papeleria1 = new ProductoPapeleria(
                "PAP-001", "Cuaderno Universitario", 12500.0, 50,
                "ESCOLAR", "Norma", "Papel reciclado", 12
        );

        ProductoPapeleria papeleria2 = new ProductoPapeleria(
                "PAP-002", "Bolígrafo Pilot G2", 8500.0, 100,
                "ESCRITURA", "Pilot", "Plástico", 6
        );

        ProductoPapeleria papeleria3 = new ProductoPapeleria(
                "PAP-003", "Carpeta de Anillos", 28000.0, 25,
                "OFICINA", "Oxford", "Cartón reciclado", 24
        );

        // ========== EJERCICIO 1: DEMOSTRACIÓN DE SOBRECARGA ==========
        System.out.println("\n\n=== 2. DEMOSTRACIÓN DE SOBRECARGA (OVERLOADING) ===");
        System.out.println("-".repeat(50));

        System.out.println("\n📦 Agregando productos con diferentes métodos:");

        // SOBRECARGA 1: Producto simple
        sistema.agregarProducto(libro1);

        // SOBRECARGA 2: Producto con cantidad inicial
        sistema.agregarProducto(libro2, 20);

        // SOBRECARGA 3: Múltiples productos
        ArrayList<Producto> nuevosProductos = new ArrayList<>();
        nuevosProductos.add(libro3);
        nuevosProductos.add(papeleria1);
        nuevosProductos.add(papeleria2);
        nuevosProductos.add(papeleria3);
        sistema.agregarProducto(nuevosProductos);

        System.out.println("\n🔍 Búsquedas con sobrecarga:");

        // SOBRECARGA 4: Buscar por código
        Producto encontrado1 = sistema.buscarProducto("LIB-002");
        if (encontrado1 != null) {
            System.out.println("✅ Encontrado por código: " + encontrado1.getNombre());
        }

        // SOBRECARGA 5: Buscar por nombre
        ArrayList<Producto> encontrados2 = sistema.buscarProductoPorNombre("cuaderno");
        System.out.println("✅ Encontrados por nombre 'cuaderno': " + encontrados2.size());

        // SOBRECARGA 6: Buscar por rango de precio
        ArrayList<Producto> encontrados3 = sistema.buscarProducto(10000, 30000);
        System.out.println("✅ Encontrados entre $10,000 y $30,000: " + encontrados3.size());

        // ========== EJERCICIO 2: DEMOSTRACIÓN DE SOBRESCRITURA ==========
        System.out.println("\n\n=== 3. DEMOSTRACIÓN DE SOBRESCRITURA (@Override) ===");
        System.out.println("-".repeat(50));

        System.out.println("\n📚 COMPARACIÓN: Libro vs Papelería (comportamiento diferente)");

        // Mismo método, resultados DIFERENTES por sobrescritura
        System.out.println("\n1. calcularPrecioFinal():");
        double precioLibro = libro1.calcularPrecioFinal();
        double precioPapeleria = papeleria1.calcularPrecioFinal();
        System.out.printf("   Libro '%s': $%.2f (5%% descuento + IVA)\n",
                libro1.getNombre(), precioLibro);
        System.out.printf("   Papelería '%s': $%.2f (10%% descuento + IVA)\n",
                papeleria1.getNombre(), precioPapeleria);

        System.out.println("\n2. obtenerDescripcionDetallada():");
        System.out.println("   " + libro1.obtenerDescripcionDetallada().replace("\n", "\n   "));
        System.out.println("\n   " + papeleria1.obtenerDescripcionDetallada().replace("\n", "\n   "));

        System.out.println("\n3. aplicarDescuentoEspecial(15%):");
        double descLibro = libro1.aplicarDescuentoEspecial(15);
        double descPapeleria = papeleria1.aplicarDescuentoEspecial(15);
        System.out.printf("   Libro: $%.2f (15%% + descuento antigüedad)\n", descLibro);
        System.out.printf("   Papelería: $%.2f (15%% + descuento por tipo)\n", descPapeleria);

        // ========== EJERCICIO 3: MÉTODOS POLIMÓRFICOS ==========
        System.out.println("\n\n=== 4. MÉTODOS POLIMÓRFICOS (aceptan cualquier Producto) ===");
        System.out.println("-".repeat(50));

        System.out.println("\n🔄 Procesando diferentes tipos con los mismos métodos:");

        // Mismo método procesa DIFERENTES tipos
        sistema.procesarProducto(libro1);      // ✅ Libro
        sistema.procesarProducto(papeleria1);  // ✅ Papelería

        System.out.println("\n💰 Calculando valores totales:");
        double valor1 = sistema.calcularValorTotal(libro1, 3);      // ✅ Libro
        double valor2 = sistema.calcularValorTotal(papeleria2, 10); // ✅ Papelería
        System.out.printf("   3 libros '%s': $%.2f\n", libro1.getNombre(), valor1);
        System.out.printf("   10 '%s': $%.2f\n", papeleria2.getNombre(), valor2);

        // ========== EJERCICIO 4: ARRAYLIST POLIMÓRFICO ==========
        System.out.println("\n\n=== 5. ARRAYLIST POLIMÓRFICO Y VINCULACIÓN DINÁMICA ===");
        System.out.println("-".repeat(50));

        // ArrayList que puede contener Libros Y ProductoPapeleria
        ArrayList<Producto> inventarioPolimorfico = sistema.getInventario();

        System.out.println("\n📦 Inventario polimórfico (" + inventarioPolimorfico.size() + " productos):");
        System.out.println("-".repeat(40));

        double valorTotal = 0;
        int contadorLibros = 0;
        int contadorPapeleria = 0;

        // POLIMORFISMO EN ACCIÓN: bucle trata todo como Producto
        for (Producto producto : inventarioPolimorfico) {
            // VINCULACIÓN DINÁMICA (Dynamic Binding):
            // En tiempo de EJECUCIÓN, Java decide qué método llamar

            // 1. obtenerDescripcionDetallada() - Cada tipo usa SU implementación
            System.out.println(producto.obtenerDescripcionDetallada());

            // 2. calcularPrecioFinal() - Comportamiento diferente por tipo
            double precioUnitario = producto.calcularPrecioFinal();
            double valorProducto = precioUnitario * producto.getStock();
            valorTotal += valorProducto;

            System.out.printf("   Precio final: $%.2f | Stock: %d | Valor: $%.2f\n",
                    precioUnitario, producto.getStock(), valorProducto);

            // 3. Identificar tipo real en tiempo de ejecución
            String tipoReal = producto.getClass().getSimpleName();
            System.out.println("   Tipo real: " + tipoReal +
                    " | ¿Es Libro?: " + (producto instanceof Libro) +
                    " | ¿Es Papelería?: " + (producto instanceof ProductoPapeleria));

            // Contadores por tipo
            if (producto instanceof Libro) {
                contadorLibros++;
            } else if (producto instanceof ProductoPapeleria) {
                contadorPapeleria++;
            }

            System.out.println("-".repeat(30));
        }

        // ========== RESUMEN Y DEMOSTRACIÓN ADICIONAL ==========
        System.out.println("\n\n=== 6. RESUMEN Y DEMOSTRACIÓN FINAL ===");
        System.out.println("=".repeat(50));

        System.out.println("\n📊 ESTADÍSTICAS DEL POLIMORFISMO:");
        System.out.println("Total productos: " + inventarioPolimorfico.size());
        System.out.println("Total libros: " + contadorLibros);
        System.out.println("Total papelería: " + contadorPapeleria);
        System.out.printf("Valor total inventario: $%.2f\n", valorTotal);

        System.out.println("\n🔄 DEMOSTRACIÓN DE VENTAS POLIMÓRFICAS:");
        sistema.venderProducto(libro2, 2);      // ✅ Vender libro
        sistema.venderProducto(papeleria3, 5);  // ✅ Vender papelería

        System.out.println("\n📋 INVENTARIO COMPLETO PROCESADO:");
        sistema.procesarInventarioCompleto();

        // ========== DEMOSTRACIÓN DE FLEXIBILIDAD ==========
        System.out.println("\n\n=== 7. FLEXIBILIDAD DEL POLIMORFISMO ===");
        System.out.println("=".repeat(50));

        System.out.println("\n🎯 ¿Qué pasaría si añadimos una nueva subclase?");
        System.out.println("Ejemplo: class Revista extends Producto { ... }");
        System.out.println("• El ArrayList<Producto> la aceptaría automáticamente ✅");
        System.out.println("• sistema.procesarProducto() funcionaría sin cambios ✅");
        System.out.println("• sistema.venderProducto() funcionaría sin cambios ✅");
        System.out.println("• Todo el código existente seguiría funcionando ✅");

        System.out.println("\n" + "=".repeat(60));
        System.out.println("✅ DEMOSTRACIÓN DE POLIMORFISMO COMPLETADA EXITOSAMENTE");
        System.out.println("=".repeat(60));
        System.out.println("\n🎯 LOGROS:");
        System.out.println("✓ Sobrecarga demostrada: 6 métodos con mismo nombre");
        System.out.println("✓ Sobrescritura demostrada: 3 métodos con @Override");
        System.out.println("✓ Polimorfismo demostrado: métodos aceptan Producto");
        System.out.println("✓ ArrayList polimórfico: almacena diferentes subclases");
        System.out.println("✓ Vinculación dinámica: en tiempo de ejecución");
    }
}