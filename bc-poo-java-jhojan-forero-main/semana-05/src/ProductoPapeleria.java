/**
 * SUBCLASE 2: ProductoPapeleria
 * Implementa polimorfismo mediante SOBRESCRITURA (@Override)
 * Comportamiento DIFERENTE al de Libro
 */
public class ProductoPapeleria extends Producto {

    // ========== ATRIBUTOS ESPECÍFICOS ==========
    private String tipo; // ESCOLAR, OFICINA, ARTES
    private String marca;
    private String material;
    private int garantiaMeses;

    // ========== CONSTRUCTOR ==========
    public ProductoPapeleria(String codigo, String nombre, double precioBase, int stock,
                             String tipo, String marca, String material, int garantiaMeses) {
        super(codigo, nombre, precioBase, stock);
        this.tipo = tipo;
        this.marca = marca;
        this.material = material;
        this.garantiaMeses = garantiaMeses;
    }

    // ========== SOBRESCRITURA DE MÉTODOS ABSTRACTOS (@Override) ==========

    /**
     * EJERCICIO 2: SOBRESCRITURA con @Override
     * COMPORTAMIENTO DIFERENTE: Papelería tiene 10% descuento + IVA
     */
    @Override
    public double calcularPrecioFinal() {
        double precioConDescuento = precioBase * 0.90; // 10% descuento papelería
        double precioConIVA = precioConDescuento * 1.19; // +19% IVA
        return precioConIVA;
    }

    /**
     * EJERCICIO 2: SOBRESCRITURA con @Override
     * Descripción específica para papelería
     */
    @Override
    public String obtenerDescripcionDetallada() {
        return "🖊️  PAPELERÍA: " + nombre +
                "\n   Tipo: " + tipo +
                "\n   Marca: " + marca +
                "\n   Material: " + material +
                "\n   Garantía: " + garantiaMeses + " meses" +
                "\n   Ecológico: " + (esEcologico() ? "SÍ 🌿" : "NO");
    }

    /**
     * EJERCICIO 2: SOBRESCRITURA con @Override
     * Descuento especial para papelería: adicional por tipo
     */
    @Override
    public double aplicarDescuentoEspecial(double porcentaje) {
        // Descuento base + descuento por tipo
        double descuentoTipo = calcularDescuentoTipo();
        double descuentoTotal = (porcentaje / 100) + descuentoTipo;
        return precioBase * (1 - descuentoTotal);
    }

    // ========== MÉTODOS ESPECÍFICOS DE PAPELERÍA ==========

    public double calcularDescuentoTipo() {
        switch (tipo.toUpperCase()) {
            case "ESCOLAR": return 0.15; // 15% descuento escolar
            case "OFICINA": return 0.10; // 10% descuento oficina
            case "ARTES": return 0.20;   // 20% descuento artes
            default: return 0.05;        // 5% otros
        }
    }

    public boolean esEcologico() {
        return material.toLowerCase().contains("reciclado") ||
                material.toLowerCase().contains("biodegradable") ||
                material.toLowerCase().contains("eco");
    }

    // ========== GETTERS ESPECÍFICOS ==========

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getMaterial() {
        return material;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }
}