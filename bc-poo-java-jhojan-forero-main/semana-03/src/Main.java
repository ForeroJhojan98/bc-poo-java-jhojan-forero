/**
 * Programa de demostración - Semana 03
 * Muestra encapsulación, constructores sobrecargados y validaciones
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║     SEMANA 03 - ENCAPSULACIÓN Y VALIDACIONES ║");
        System.out.println("║        Librería 'Mundo del Libro'            ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");

        // ========== DEMOSTRACIÓN LIBROS ==========
        System.out.println("=== 1. DEMOSTRACIÓN CLASE LIBROMEJORADO ===\n");

        try {
            // Crear libros con diferentes constructores
            System.out.println("📚 Creando libros con constructores sobrecargados:");

            // Constructor 1: Completo
            LibroMejorado libro1 = new LibroMejorado(
                    "978-958-42-1234-5",
                    "Cien Años de Soledad",
                    "Gabriel García Márquez",
                    45000.0,
                    10,
                    "Realismo Mágico",
                    471
            );
            System.out.println("✓ Libro 1 creado (constructor completo)");

            // Constructor 2: Intermedio
            LibroMejorado libro2 = new LibroMejorado(
                    "978-607-12-3456-7",
                    "El Principito",
                    "Antoine de Saint-Exupéry",
                    32000.0,
                    5
            );
            System.out.println("✓ Libro 2 creado (constructor intermedio)");

            // Constructor 3: Básico
            LibroMejorado libro3 = new LibroMejorado(
                    "978-84-376-5432-1",
                    "Don Quijote de la Mancha",
                    58000.0
            );
            System.out.println("✓ Libro 3 creado (constructor básico)\n");

            // Mostrar detalles
            libro1.mostrarDetalles();
            libro2.mostrarDetalles();
            libro3.mostrarDetalles();

            // Demostrar validaciones en setters
            System.out.println("\n🔧 Probando validaciones en setters:");

            try {
                libro1.setPrecioVenta(-100); // Esto debería fallar
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Validación funcionando: " + e.getMessage());
            }

            try {
                libro1.setStockDisponible(-5); // Esto debería fallar
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Validación funcionando: " + e.getMessage());
            }

            // Demostrar getters
            System.out.println("\n📊 Usando getters:");
            System.out.println("Título libro 1: " + libro1.getTitulo());
            System.out.println("Precio libro 2: $" + libro2.getPrecioVenta());
            System.out.println("Stock libro 3: " + libro3.getStockDisponible());

            // Demostrar métodos de negocio
            System.out.println("\n💰 Cálculos de precios:");
            double descuento20 = libro1.calcularPrecioConDescuento(20);
            System.out.println("Precio con 20% descuento: $" + descuento20);

            // Vender unidades
            System.out.println("\n🛒 Venta de unidades:");
            boolean ventaExitosa = libro1.vender(3);
            System.out.println("Venta de 3 unidades: " + (ventaExitosa ? "EXITOSA" : "FALLIDA"));
            System.out.println("Nuevo stock: " + libro1.getStockDisponible());

        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error durante creación de libros: " + e.getMessage());
        }

        // ========== DEMOSTRACIÓN CLIENTES ==========
        System.out.println("\n\n=== 2. DEMOSTRACIÓN CLASE CLIENTEMEJORADO ===\n");

        try {
            // Crear clientes con diferentes constructores
            System.out.println("👥 Creando clientes con constructores sobrecargados:");

            // Constructor 1: Completo
            ClienteMejorado cliente1 = new ClienteMejorado(
                    "1020304050",
                    "Jhojan Forero Infante",
                    "jhojan.f@mail.com",
                    "3101234567",
                    "Calle 72 # 15-30, Bogotá",
                    "ESTUDIANTE"
            );
            System.out.println("✓ Cliente 1 creado (constructor completo)");

            // Constructor 2: Sin teléfono/dirección
            ClienteMejorado cliente2 = new ClienteMejorado(
                    "1098765432",
                    "Laura Gómez Pérez",
                    "laura.g@mail.com",
                    "DOCENTE"
            );
            System.out.println("✓ Cliente 2 creado (constructor intermedio)");

            // Constructor 3: Mínimo (regular)
            ClienteMejorado cliente3 = new ClienteMejorado(
                    "2010203040",
                    "Carlos Ruiz",
                    "carlos.r@mail.com"
            );
            System.out.println("✓ Cliente 3 creado (constructor básico)\n");

            // Mostrar información
            cliente1.mostrarInformacion();
            cliente2.mostrarInformacion();
            cliente3.mostrarInformacion();

            // Demostrar validaciones
            System.out.println("\n🔧 Probando validaciones:");

            try {
                cliente1.setEmail("correo-invalido"); // Esto debería fallar
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Validación email funcionando: " + e.getMessage());
            }

            try {
                cliente1.setTipoCliente("INVALIDO"); // Esto debería fallar
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Validación tipo cliente funcionando: " + e.getMessage());
            }

            // Demostrar métodos de negocio
            System.out.println("\n🎯 Sistema de fidelidad:");
            cliente1.acumularPuntos(150);
            cliente1.acumularPuntos(75);

            System.out.println("\n💳 Canje de puntos:");
            cliente1.canjearPuntos(100);
            cliente1.canjearPuntos(200); // Debería fallar

            System.out.println("\n💰 Descuentos por tipo de cliente:");
            double montoCompra = 100000;
            double precioCliente1 = cliente1.aplicarDescuentoTipoCliente(montoCompra);
            double precioCliente2 = cliente2.aplicarDescuentoTipoCliente(montoCompra);
            double precioCliente3 = cliente3.aplicarDescuentoTipoCliente(montoCompra);

            System.out.println("Monto original: $" + montoCompra);
            System.out.println("Cliente ESTUDIANTE: $" + precioCliente1 + " (10% desc)");
            System.out.println("Cliente DOCENTE: $" + precioCliente2 + " (15% desc)");
            System.out.println("Cliente REGULAR: $" + precioCliente3 + " (5% desc)");

        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error durante creación de clientes: " + e.getMessage());
        }

        // ========== DEMOSTRACIÓN INTEGRACIÓN ==========
        System.out.println("\n\n=== 3. DEMOSTRACIÓN INTEGRACIÓN ===\n");

        try {
            // Crear libro y cliente
            LibroMejorado libroEjemplo = new LibroMejorado(
                    "978-950-07-6543-2",
                    "Rayuela",
                    "Julio Cortázar",
                    42000.0,
                    8
            );

            ClienteMejorado clienteEjemplo = new ClienteMejorado(
                    "3040506070",
                    "Ana María Torres",
                    "ana.t@mail.com",
                    "PREMIUM"
            );

            // Simular compra
            System.out.println("🛍️ Simulando compra:");
            System.out.println("Cliente: " + clienteEjemplo.getNombreCompleto());
            System.out.println("Libro: " + libroEjemplo.getTitulo());
            System.out.println("Precio original: $" + libroEjemplo.getPrecioVenta());

            // Aplicar descuento por tipo de cliente
            double precioConDescuento = clienteEjemplo.aplicarDescuentoTipoCliente(
                    libroEjemplo.getPrecioVenta()
            );
            System.out.println("Precio con descuento PREMIUM (20%): $" + precioConDescuento);

            // Vender libro
            if (libroEjemplo.vender(1)) {
                System.out.println("✅ Compra exitosa!");

                // Acumular puntos (1 punto por cada $10,000)
                int puntosGanados = (int)(precioConDescuento / 10000);
                clienteEjemplo.acumularPuntos(puntosGanados);

                // Mostrar estado final
                System.out.println("\n📊 Estado final:");
                System.out.println("Stock restante: " + libroEjemplo.getStockDisponible());
                System.out.println("Puntos cliente: " + clienteEjemplo.getPuntosFidelidad());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error en integración: " + e.getMessage());
        }

        // ========== DEMOSTRACIÓN ERRORES ==========
        System.out.println("\n\n=== 4. DEMOSTRACIÓN MANEJO DE ERRORES ===\n");

        System.out.println("⚠️ Intentando crear objetos con datos inválidos:\n");

        // Intentos que deberían fallar
        String[] pruebasError = {
                "Libro con ISBN vacío",
                "Libro con precio negativo",
                "Libro con stock negativo",
                "Cliente con email inválido",
                "Cliente con documento corto",
                "Cliente con tipo inválido"
        };

        for (String prueba : pruebasError) {
            System.out.print("Probando: " + prueba + "... ");
            try {
                switch (prueba) {
                    case "Libro con ISBN vacío":
                        new LibroMejorado("", "Título", 10000);
                        break;
                    case "Libro con precio negativo":
                        new LibroMejorado("978-123-456", "Libro", -5000);
                        break;
                    case "Libro con stock negativo":
                        new LibroMejorado("978-123-456", "Libro", "Autor", 10000, -5);
                        break;
                    case "Cliente con email inválido":
                        new ClienteMejorado("12345678", "Nombre", "email-invalido");
                        break;
                    case "Cliente con documento corto":
                        new ClienteMejorado("123", "Nombre", "email@valido.com");
                        break;
                    case "Cliente con tipo inválido":
                        new ClienteMejorado("12345678", "Nombre", "email@valido.com", "INVALIDO");
                        break;
                }
                System.out.println("❌ ERROR - No debió crearse");
            } catch (IllegalArgumentException e) {
                System.out.println("✅ CORRECTO - Validación funcionó: " + e.getMessage());
            }
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("✅ DEMOSTRACIÓN COMPLETADA EXITOSAMENTE");
        System.out.println("=".repeat(50));
    }
}