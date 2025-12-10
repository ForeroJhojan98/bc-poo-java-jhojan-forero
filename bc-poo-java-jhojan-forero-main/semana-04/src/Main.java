import java.util.ArrayList;

/**
 * CLASE PRINCIPAL - Demostración de Herencia y Polimorfismo
 * Ejercicio 4: Array/ArrayList polimórfico
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║     SEMANA 04 - HERENCIA Y POLIMORFISMO        ║");
        System.out.println("║       Librería 'Mundo del Libro'               ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        // ========== CREACIÓN DE OBJETOS ==========
        System.out.println("=== 1. CREANDO PRODUCTOS DE DIFERENTES TIPOS ===\n");

        // ARRAY POLIMÓRFICO: puede contener CUALQUIER objeto Producto
        ArrayList<Producto> inventario = new ArrayList<>();

        // ========== CREAR LIBROS (SUBCLASE 1) ==========
        System.out.println("📚 Creando libros...");

        Libro libro1 = new Libro(
                "LIB-001",                      // codigo
                "Cien Años de Soledad",         // nombre
                45000.0,                        // precioBase
                15,                             // stock
                "978-958-42-1234-5",            // isbn
                "Gabriel García Márquez",       // autor
                "Sudamericana",                 // editorial
                1967                            // anioPublicacion
        );
        inventario.add(libro1);
        System.out.println("✓ Libro 1 creado: " + libro1.getNombre());

        Libro libro2 = new Libro(
                "LIB-002",
                "El Principito",
                32000.0,
                8,
                "978-607-12-3456-7",
                "Antoine de Saint-Exupéry",
                "Salamandra",
                1943
        );
        inventario.add(libro2);
        System.out.println("✓ Libro 2 creado: " + libro2.getNombre());

        // ========== CREAR PRODUCTOS DE PAPELERÍA (SUBCLASE 2) ==========
        System.out.println("\n🖊️ Creando productos de papelería...");

        ProductoPapeleria papeleria1 = new ProductoPapeleria(
                "PAP-001",                      // codigo
                "Cuaderno Universitario",       // nombre
                12500.0,                        // precioBase
                50,                             // stock
                "ESCOLAR",                      // tipo
                "Norma",                        // marca
                "Papel reciclado",              // material
                12                              // garantiaMeses
        );
        inventario.add(papeleria1);
        System.out.println("✓ Papelería 1 creado: " + papeleria1.getNombre());

        ProductoPapeleria papeleria2 = new ProductoPapeleria(
                "PAP-002",
                "Bolígrafo Pilot G2",
                8500.0,
                100,
                "ESCRITURA",
                "Pilot",
                "Plástico",
                6
        );
        inventario.add(papeleria2);
        System.out.println("✓ Papelería 2 creado: " + papeleria2.getNombre());

        // ========== DEMOSTRACIÓN DE POLIMORFISMO ==========
        System.out.println("\n\n=== 2. POLIMORFISMO EN ACCIÓN ===");
        System.out.println("=".repeat(40));

        System.out.println("\n📊 Mostrando información de TODOS los productos:");
        System.out.println("-".repeat(40));

        // POLIMORFISMO: Tratamos todos como Producto, pero cada uno se comporta diferente
        for (Producto producto : inventario) {
            // Esto llama a mostrarInfo() específico de cada clase
            producto.mostrarInfo();
        }

        // ========== DEMOSTRACIÓN DE HERENCIA ==========
        System.out.println("\n\n=== 3. DEMOSTRACIÓN DE HERENCIA ===");
        System.out.println("=".repeat(40));

        System.out.println("\n💰 Precios con IVA (método heredado de Producto):");
        System.out.println("-".repeat(40));

        for (Producto producto : inventario) {
            System.out.printf("%s: $%.2f → $%.2f (con IVA 19%%)\n",
                    producto.getNombre(),
                    producto.getPrecioBase(),
                    producto.calcularPrecioConIVA());
        }

        // ========== DEMOSTRACIÓN DE MÉTODOS ESPECÍFICOS ==========
        System.out.println("\n\n=== 4. MÉTODOS ESPECÍFICOS DE CADA CLASE ===");
        System.out.println("=".repeat(40));

        System.out.println("\n🎯 Accediendo a métodos específicos con casting:");
        System.out.println("-".repeat(40));

        for (Producto producto : inventario) {
            if (producto instanceof Libro) {
                Libro libro = (Libro) producto; // Casting a Libro
                System.out.printf("📖 %s: Antigüedad: %d años | ¿Bestseller?: %s\n",
                        libro.getNombre(),
                        libro.calcularAntiguedad(),
                        libro.esBestseller() ? "SÍ" : "NO");

            } else if (producto instanceof ProductoPapeleria) {
                ProductoPapeleria papeleria = (ProductoPapeleria) producto; // Casting a ProductoPapeleria
                System.out.printf("🖊️ %s: Tipo: %s | ¿Ecológico?: %s\n",
                        papeleria.getNombre(),
                        papeleria.getTipo(),
                        papeleria.esEcologico() ? "SÍ 🌿" : "NO");
            }
        }

        // ========== DEMOSTRACIÓN DE VENTAS ==========
        System.out.println("\n\n=== 5. SIMULACIÓN DE VENTAS ===");
        System.out.println("=".repeat(40));

        // Vender algunos productos (polimorfismo en acción)
        System.out.println("\n🛒 Realizando ventas:");
        System.out.println("-".repeat(40));

        inventario.get(0).vender(3);  // Vender 3 unidades del primer producto (Libro)
        inventario.get(2).vender(10); // Vender 10 unidades del tercer producto (Papelería)
        inventario.get(1).vender(15); // Intentar vender más de lo disponible (debería fallar)

        // ========== REPONER STOCK ==========
        System.out.println("\n\n=== 6. REPOSICIÓN DE STOCK ===");
        System.out.println("=".repeat(40));

        System.out.println("\n📦 Reponiendo stock:");
        System.out.println("-".repeat(40));

        // Usar método heredado de Producto
        inventario.get(1).reponerStock(20); // Reponer stock del libro 2
        inventario.get(3).reponerStock(50); // Reponer stock de papelería 2

        // ========== RESUMEN FINAL ==========
        System.out.println("\n\n=== 7. RESUMEN DEL INVENTARIO ===");
        System.out.println("=".repeat(40));

        System.out.println("\n📊 Estado final del inventario:");
        System.out.println("-".repeat(40));

        int totalProductos = 0;
        int totalLibros = 0;
        int totalPapeleria = 0;
        double valorTotal = 0;

        for (Producto producto : inventario) {
            totalProductos++;

            if (producto instanceof Libro) {
                totalLibros++;
            } else if (producto instanceof ProductoPapeleria) {
                totalPapeleria++;
            }

            valorTotal += producto.getPrecioBase() * producto.getStock();

            System.out.printf("%s - Stock: %d - Valor: $%.2f\n",
                    producto.getNombre(),
                    producto.getStock(),
                    producto.getPrecioBase() * producto.getStock());
        }

        System.out.println("\n📈 ESTADÍSTICAS:");
        System.out.println("-".repeat(40));
        System.out.println("Total productos: " + totalProductos);
        System.out.println("Total libros: " + totalLibros);
        System.out.println("Total papelería: " + totalPapeleria);
        System.out.printf("Valor total en inventario: $%.2f\n", valorTotal);

        // ========== VERIFICACIÓN DE REQUISITOS SEMANA 4 ==========
        System.out.println("\n\n=== 8. VERIFICACIÓN DE REQUISITOS SEMANA 4 ===");
        System.out.println("=".repeat(40));

        System.out.println("\n✅ REQUISITOS CUMPLIDOS:");
        System.out.println("1. ✅ Clase padre Producto con atributos protected");
        System.out.println("2. ✅ Dos subclases: Libro y ProductoPapeleria");
        System.out.println("3. ✅ Uso de super() en constructores de subclases");
        System.out.println("4. ✅ Uso de @Override en métodos sobrescritos");
        System.out.println("5. ✅ ArrayList polimórfico: ArrayList<Producto>");
        System.out.println("6. ✅ Polimorfismo demostrado en bucle for-each");

        System.out.println("\n" + "=".repeat(50));
        System.out.println("🎉 DEMOSTRACIÓN COMPLETADA EXITOSAMENTE");
        System.out.println("=".repeat(50));
    }
}