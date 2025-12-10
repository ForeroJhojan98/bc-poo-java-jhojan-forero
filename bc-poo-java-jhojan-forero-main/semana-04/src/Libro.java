/**
 * SUBCLASE 1: Libro
 * Extiende Producto - Representa libros en la librería
 * Ejercicio 2: Subclase que hereda de la clase padre
 */
public class Libro extends Producto {

    // ========== ATRIBUTOS ESPECÍFICOS DE LIBRO ==========
    private String isbn;
    private String autor;
    private String editorial;
    private int anioPublicacion;

    // ========== CONSTRUCTOR CON super() ==========
    /**
     * Constructor de Libro - Llama al constructor padre con super()
     * @param codigo Código del producto (hereda de Producto)
     * @param nombre Nombre del libro (hereda de Producto)
     * @param precioBase Precio base (hereda de Producto)
     * @param stock Stock disponible (hereda de Producto)
     * @param isbn ISBN único del libro
     * @param autor Autor del libro
     * @param editorial Editorial del libro
     * @param anioPublicacion Año de publicación
     */
    public Libro(String codigo, String nombre, double precioBase, int stock,
                 String isbn, String autor, String editorial, int anioPublicacion) {
        // LLAMADA AL CONSTRUCTOR PADRE CON super()
        super(codigo, nombre, precioBase, stock);

        // Inicializar atributos específicos de Libro
        this.isbn = isbn;
        this.autor = autor;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
    }

    // ========== MÉTODOS ESPECÍFICOS DE LIBRO ==========

    /**
     * Método específico para libros - Calcular antigüedad
     * @return Años desde su publicación
     */
    public int calcularAntiguedad() {
        int anioActual = 2024; // Podría ser dinámico
        return anioActual - anioPublicacion;
    }

    /**
     * Método específico para libros - Verificar si es bestseller
     * @return true si cumple condiciones de bestseller
     */
    public boolean esBestseller() {
        // Regla simple: libros con más de 10 años pueden ser bestsellers clásicos
        return calcularAntiguedad() > 10 && precioBase > 30000;
    }

    // ========== SOBRESCRITURA DE MÉTODOS (OVERRIDE) ==========

    /**
     * SOBRESCRITURA DEL MÉTODO mostrarInfo()
     * @Override indica que estamos sobrescribiendo un método del padre
     */
    @Override
    public void mostrarInfo() {
        // Primero llamamos al método del padre para información básica
        System.out.println("\n📚 INFORMACIÓN DEL LIBRO");
        System.out.println("Código: " + codigo);           // Acceso a atributo protected
        System.out.println("Nombre: " + nombre);           // Acceso a atributo protected
        System.out.println("Precio Base: $" + precioBase); // Acceso a atributo protected
        System.out.println("Stock: " + stock + " unidades"); // Acceso a atributo protected

        // Luego mostramos información específica de Libro
        System.out.println("ISBN: " + isbn);
        System.out.println("Autor: " + autor);
        System.out.println("Editorial: " + editorial);
        System.out.println("Año: " + anioPublicacion);
        System.out.println("Antigüedad: " + calcularAntiguedad() + " años");
        System.out.println("Precio con IVA: $" + calcularPrecioConIVA());
        System.out.println("¿Bestseller?: " + (esBestseller() ? "SÍ ✅" : "NO"));
    }

    /**
     * SOBRESCRITURA DEL MÉTODO vender() con comportamiento específico
     */
    @Override
    public boolean vender(int cantidad) {
        System.out.println("\n🛒 PROCESANDO VENTA DE LIBRO:");

        // Comportamiento específico para libros: verificar si es edición especial
        if (calcularAntiguedad() > 20) {
            System.out.println("⚠️  Este libro tiene más de 20 años (edición especial)");
        }

        // Llamamos al método del padre para realizar la venta
        return super.vender(cantidad);
    }

    // ========== GETTERS ESPECÍFICOS ==========

    public String getIsbn() {
        return isbn;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }
}