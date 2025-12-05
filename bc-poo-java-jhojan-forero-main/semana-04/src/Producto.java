/**
 * CLASE PADRE: Producto
 * Clase base para todos los productos de la librería "Mundo del Libro"
 * Ejercicio 1: Crear clase padre con atributos protected y métodos heredables
 */
public class Producto {

    // ========== ATRIBUTOS PROTECTED (compartidos con subclases) ==========
    protected String codigo;
    protected String nombre;
    protected double precioBase;
    protected int stock;

    // ========== CONSTRUCTOR COMPLETO ==========
    /**
     * Constructor de la clase padre
     * @param codigo Código único del producto
     * @param nombre Nombre del producto
     * @param precioBase Precio sin impuestos
     * @param stock Cantidad disponible
     */
    public Producto(String codigo, String nombre, double precioBase, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.stock = stock;
    }

    // ========== MÉTODOS QUE PUEDEN SER HEREDADOS ==========

    /**
     * MÉTODO 1: Mostrar información básica del producto
     * Puede ser heredado y sobrescrito por subclases
     */
    public void mostrarInfo() {
        System.out.println("\n📦 INFORMACIÓN DEL PRODUCTO");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio Base: $" + precioBase);
        System.out.println("Stock: " + stock + " unidades");
    }

    /**
     * MÉTODO 2: Calcular precio con IVA (19% Colombia)
     * Método concreto que puede ser usado por todas las subclases
     * @return Precio con IVA incluido
     */
    public double calcularPrecioConIVA() {
        final double IVA = 0.19; // 19% IVA
        return precioBase * (1 + IVA);
    }

    /**
     * MÉTODO 3: Vender unidades del producto
     * @param cantidad Cantidad a vender
     * @return true si la venta fue exitosa
     */
    public boolean vender(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("❌ Error: Cantidad debe ser positiva");
            return false;
        }

        if (stock >= cantidad) {
            stock -= cantidad;
            System.out.println("✅ Vendidas " + cantidad + " unidades de " + nombre);
            System.out.println("   Stock restante: " + stock);
            return true;
        } else {
            System.out.println("❌ Stock insuficiente de " + nombre);
            System.out.println("   Stock disponible: " + stock + ", solicitado: " + cantidad);
            return false;
        }
    }

    /**
     * MÉTODO 4: Reponer stock
     * @param cantidad Cantidad a reponer
     */
    public void reponerStock(int cantidad) {
        if (cantidad > 0) {
            stock += cantidad;
            System.out.println("✅ Repuestas " + cantidad + " unidades de " + nombre);
            System.out.println("   Nuevo stock: " + stock);
        }
    }

    // ========== GETTERS ==========

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public int getStock() {
        return stock;
    }

    // ========== SETTERS ==========

    public void setPrecioBase(double precioBase) {
        if (precioBase >= 0) {
            this.precioBase = precioBase;
        }
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        }
    }
}