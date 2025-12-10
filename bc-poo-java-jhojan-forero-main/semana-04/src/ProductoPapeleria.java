/**
 * SUBCLASE 2: ProductoPapeleria
 * Extiende Producto - Representa productos de papelería
 * Ejercicio 2: Segunda subclase que hereda de la clase padre
 */
public class ProductoPapeleria extends Producto {

    // ========== ATRIBUTOS ESPECÍFICOS DE PAPELERÍA ==========
    private String tipo; // ESCOLAR, OFICINA, ARTES
    private String marca;
    private String material;
    private int garantiaMeses; // Garantía en meses

    // ========== CONSTRUCTOR CON super() ==========
    /**
     * Constructor de ProductoPapeleria
     * @param codigo Código del producto (hereda de Producto)
     * @param nombre Nombre del producto (hereda de Producto)
     * @param precioBase Precio base (hereda de Producto)
     * @param stock Stock disponible (hereda de Producto)
     * @param tipo Tipo de producto de papelería
     * @param marca Marca del producto
     * @param material Material principal
     * @param garantiaMeses Meses de garantía
     */
    public ProductoPapeleria(String codigo, String nombre, double precioBase, int stock,
                             String tipo, String marca, String material, int garantiaMeses) {
        // LLAMADA AL CONSTRUCTOR PADRE CON super()
        super(codigo, nombre, precioBase, stock);

        // Inicializar atributos específicos
        this.tipo = tipo;
        this.marca = marca;
        this.material = material;
        this.garantiaMeses = garantiaMeses;
    }

    // ========== MÉTODOS ESPECÍFICOS DE PAPELERÍA ==========

    /**
     * Método específico para papelería - Calcular descuento por tipo
     * @return Porcentaje de descuento según el tipo
     */
    public double calcularDescuentoTipo() {
        switch (tipo.toUpperCase()) {
            case "ESCOLAR": return 0.10; // 10% descuento para escolar
            case "OFICINA": return 0.05; // 5% descuento para oficina
            case "ARTES": return 0.15;   // 15% descuento para artes
            default: return 0.0;
        }
    }

    /**
     * Método específico para papelería - Verificar si es ecológico
     * @return true si el material es ecológico
     */
    public boolean esEcologico() {
        String materialLower = material.toLowerCase();
        return materialLower.contains("reciclado") ||
                materialLower.contains("biodegradable") ||
                materialLower.contains("eco");
    }

    // ========== SOBRESCRITURA DE MÉTODOS (OVERRIDE) ==========

    /**
     * SOBRESCRITURA DEL MÉTODO mostrarInfo()
     * @Override indica que estamos sobrescribiendo un método del padre
     */
    @Override
    public void mostrarInfo() {
        // Primero llamamos al método del padre para información básica
        System.out.println("\n🖊️  INFORMACIÓN DE PAPELERÍA");
        System.out.println("Código: " + codigo);           // Acceso a atributo protected
        System.out.println("Nombre: " + nombre);           // Acceso a atributo protected
        System.out.println("Precio Base: $" + precioBase); // Acceso a atributo protected
        System.out.println("Stock: " + stock + " unidades"); // Acceso a atributo protected

        // Luego mostramos información específica de Papelería
        System.out.println("Tipo: " + tipo);
        System.out.println("Marca: " + marca);
        System.out.println("Material: " + material);
        System.out.println("Garantía: " + garantiaMeses + " meses");
        System.out.println("Precio con IVA: $" + calcularPrecioConIVA());
        System.out.println("Descuento por tipo: " + (calcularDescuentoTipo() * 100) + "%");
        System.out.println("¿Ecológico?: " + (esEcologico() ? "SÍ 🌿" : "NO"));
    }

    /**
     * SOBRESCRITURA DEL MÉTODO vender() con comportamiento específico
     */
    @Override
    public boolean vender(int cantidad) {
        System.out.println("\n🛒 PROCESANDO VENTA DE PAPELERÍA:");

        // Comportamiento específico para papelería: verificar garantía
        if (garantiaMeses > 0) {
            System.out.println("✅ Este producto tiene " + garantiaMeses + " meses de garantía");
        }

        // Verificar si es ecológico para mensaje especial
        if (esEcologico()) {
            System.out.println("🌿 Producto ecológico - ¡Gracias por cuidar el planeta!");
        }

        // Llamamos al método del padre para realizar la venta
        return super.vender(cantidad);
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