/**
 * CLASE PADRE: Producto (MEJORADA para polimorfismo)
 * Ahora con métodos abstractos para forzar sobrescritura
 */
public abstract class Producto {

    // ========== ATRIBUTOS PROTECTED ==========
    protected String codigo;
    protected String nombre;
    protected double precioBase;
    protected int stock;

    // ========== CONSTRUCTOR ==========
    public Producto(String codigo, String nombre, double precioBase, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.stock = stock;
    }

    // ========== MÉTODOS ABSTRACTOS (DEBEN ser sobrescritos) ==========

    /**
     * MÉTODO ABSTRACTO: Calcular precio final
     * Cada subclase implementa SU propia lógica
     */
    public abstract double calcularPrecioFinal();

    /**
     * MÉTODO ABSTRACTO: Obtener descripción detallada
     * Cada subclase describe SU tipo específico
     */
    public abstract String obtenerDescripcionDetallada();

    /**
     * MÉTODO ABSTRACTO: Aplicar descuento especial
     * Cada tipo de producto tiene descuentos diferentes
     */
    public abstract double aplicarDescuentoEspecial(double porcentaje);

    // ========== MÉTODOS CONCRETOS (compartidos) ==========

    public double calcularPrecioConIVA() {
        final double IVA = 0.19;
        return precioBase * (1 + IVA);
    }

    public boolean vender(int cantidad) {
        if (stock >= cantidad) {
            stock -= cantidad;
            return true;
        }
        return false;
    }

    public void reponerStock(int cantidad) {
        stock += cantidad;
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

    // ========== MÉTODO toString() ==========

    @Override
    public String toString() {
        return nombre + " [" + codigo + "] - $" + precioBase + " - Stock: " + stock;
    }
}