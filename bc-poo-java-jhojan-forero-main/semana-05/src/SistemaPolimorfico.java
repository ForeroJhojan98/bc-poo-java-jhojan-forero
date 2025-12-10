import java.util.ArrayList;

/**
 * CLASE GESTORA: SistemaPolimorfico
 * EJERCICIO 1: Implementa SOBRECARGA (Overloading)
 * EJERCICIO 3: Implementa métodos POLIMÓRFICOS
 */
public class SistemaPolimorfico {

    private ArrayList<Producto> inventario;

    // ========== CONSTRUCTOR ==========
    public SistemaPolimorfico() {
        this.inventario = new ArrayList<>();
    }

    // ========== EJERCICIO 1: SOBRECARGA DE MÉTODOS ==========

    /**
     * SOBRECARGA 1: Agregar producto básico
     */
    public void agregarProducto(Producto producto) {
        inventario.add(producto);
        System.out.println("✅ Producto agregado: " + producto.getNombre());
    }

    /**
     * SOBRECARGA 2: Agregar producto con cantidad inicial
     */
    public void agregarProducto(Producto producto, int cantidadInicial) {
        producto.reponerStock(cantidadInicial);
        inventario.add(producto);
        System.out.println("✅ Producto agregado: " + producto.getNombre() +
                " (Stock inicial: " + cantidadInicial + ")");
    }

    /**
     * SOBRECARGA 3: Agregar múltiples productos
     */
    public void agregarProducto(ArrayList<Producto> productos) {
        for (Producto p : productos) {
            inventario.add(p);
            System.out.println("✅ Agregado: " + p.getNombre());
        }
        System.out.println("📦 Total agregados: " + productos.size() + " productos");
    }

    // ========== SOBRECARGA EN BÚSQUEDA ==========

    /**
     * SOBRECARGA 4: Buscar por código
     */
    public Producto buscarProducto(String codigo) {
        for (Producto p : inventario) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        System.out.println("❌ No encontrado: " + codigo);
        return null;
    }

    /**
     * SOBRECARGA 5: Buscar por nombre (puede haber múltiples)
     */
    public ArrayList<Producto> buscarProductoPorNombre(String nombre) {
        ArrayList<Producto> resultados = new ArrayList<>();
        for (Producto p : inventario) {
            if (p.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    /**
     * SOBRECARGA 6: Buscar por rango de precio
     */
    public ArrayList<Producto> buscarProducto(double precioMin, double precioMax) {
        ArrayList<Producto> resultados = new ArrayList<>();
        for (Producto p : inventario) {
            if (p.getPrecioBase() >= precioMin && p.getPrecioBase() <= precioMax) {
                resultados.add(p);
            }
        }
        return resultados;
    }

    // ========== EJERCICIO 3: MÉTODOS POLIMÓRFICOS ==========

    /**
     * MÉTODO POLIMÓRFICO 1: Procesar cualquier Producto
     * Acepta Libro O ProductoPapeleria (o cualquier subclase futura)
     */
    public void procesarProducto(Producto producto) {
        System.out.println("\n🔄 PROCESANDO PRODUCTO:");
        System.out.println(producto.obtenerDescripcionDetallada()); // POLIMORFISMO

        double precioFinal = producto.calcularPrecioFinal(); // POLIMORFISMO
        System.out.printf("💰 Precio final: $%.2f\n", precioFinal);

        System.out.println("📊 Stock actual: " + producto.getStock());
    }

    /**
     * MÉTODO POLIMÓRFICO 2: Calcular valor total de cualquier Producto
     */
    public double calcularValorTotal(Producto producto, int cantidad) {
        return producto.calcularPrecioFinal() * cantidad; // POLIMORFISMO
    }

    /**
     * MÉTODO POLIMÓRFICO 3: Aplicar descuento a cualquier Producto
     */
    public double aplicarDescuentoProducto(Producto producto, double porcentaje) {
        return producto.aplicarDescuentoEspecial(porcentaje); // POLIMORFISMO
    }

    // ========== MÉTODOS DE GESTIÓN ==========

    /**
     * Procesar inventario completo (POLIMORFISMO en bucle)
     */
    public void procesarInventarioCompleto() {
        System.out.println("\n📋 INVENTARIO COMPLETO (" + inventario.size() + " productos)");
        System.out.println("=".repeat(50));

        double valorTotal = 0;
        int totalLibros = 0;
        int totalPapeleria = 0;

        for (Producto p : inventario) {
            // POLIMORFISMO: Cada producto se comporta según su tipo real
            System.out.println(p.obtenerDescripcionDetallada());

            double precio = p.calcularPrecioFinal(); // Dynamic binding
            valorTotal += precio * p.getStock();

            // Contar por tipo
            if (p instanceof Libro) {
                totalLibros++;
            } else if (p instanceof ProductoPapeleria) {
                totalPapeleria++;
            }

            System.out.printf("💵 Precio c/u: $%.2f | Stock: %d | Valor: $%.2f\n",
                    precio, p.getStock(), precio * p.getStock());
            System.out.println("-".repeat(30));
        }

        System.out.println("\n📊 RESUMEN:");
        System.out.println("Total libros: " + totalLibros);
        System.out.println("Total papelería: " + totalPapeleria);
        System.out.printf("Valor total inventario: $%.2f\n", valorTotal);
    }

    /**
     * Vender producto (POLIMORFISMO)
     */
    public boolean venderProducto(Producto producto, int cantidad) {
        System.out.println("\n🛒 INTENTANDO VENDER:");
        System.out.println("Producto: " + producto.getNombre());
        System.out.println("Cantidad: " + cantidad);

        boolean exito = producto.vender(cantidad); // POLIMORFISMO

        if (exito) {
            double total = producto.calcularPrecioFinal() * cantidad;
            System.out.printf("✅ Venta exitosa! Total: $%.2f\n", total);
        } else {
            System.out.println("❌ Venta fallida. Stock insuficiente.");
        }

        return exito;
    }

    // ========== GETTER ==========

    public ArrayList<Producto> getInventario() {
        return inventario;
    }
}