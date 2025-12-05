/**
 * SUBCLASE 1: Libro
 * Implementa polimorfismo mediante SOBRESCRITURA (@Override)
 */
public class Libro extends Producto {

    // ========== ATRIBUTOS ESPECÍFICOS ==========
    private String isbn;
    private String autor;
    private String editorial;
    private int anioPublicacion;
    private String genero;

    // ========== CONSTRUCTOR ==========
    public Libro(String codigo, String nombre, double precioBase, int stock,
                 String isbn, String autor, String editorial,
                 int anioPublicacion, String genero) {
        super(codigo, nombre, precioBase, stock);
        this.isbn = isbn;
        this.autor = autor;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.genero = genero;
    }

    // ========== SOBRESCRITURA DE MÉTODOS ABSTRACTOS (@Override) ==========

    /**
     * EJERCICIO 2: SOBRESCRITURA con @Override
     * Libros tienen 5% de descuento promocional + IVA
     */
    @Override
    public double calcularPrecioFinal() {
        double precioConDescuento = precioBase * 0.95; // 5% descuento libros
        double precioConIVA = precioConDescuento * 1.19; // +19% IVA
        return precioConIVA;
    }

    /**
     * EJERCICIO 2: SOBRESCRITURA con @Override
     * Descripción específica para libros
     */
    @Override
    public String obtenerDescripcionDetallada() {
        int antiguedad = 2024 - anioPublicacion;
        return "📚 LIBRO: " + nombre +
                "\n   Autor: " + autor +
                "\n   Editorial: " + editorial +
                "\n   Año: " + anioPublicacion + " (" + antiguedad + " años)" +
                "\n   Género: " + genero +
                "\n   ISBN: " + isbn;
    }

    /**
     * EJERCICIO 2: SOBRESCRITURA con @Override
     * Descuento especial para libros: adicional por antigüedad
     */
    @Override
    public double aplicarDescuentoEspecial(double porcentaje) {
        // Descuento base + descuento por antigüedad
        double descuentoAntiguedad = calcularDescuentoPorAntiguedad();
        double descuentoTotal = (porcentaje / 100) + descuentoAntiguedad;
        return precioBase * (1 - descuentoTotal);
    }

    // ========== MÉTODOS ESPECÍFICOS DE LIBRO ==========

    public double calcularDescuentoPorAntiguedad() {
        int antiguedad = 2024 - anioPublicacion;
        if (antiguedad > 20) return 0.15; // 15% si >20 años
        if (antiguedad > 10) return 0.10; // 10% si >10 años
        if (antiguedad > 5) return 0.05;  // 5% si >5 años
        return 0.0;
    }

    public boolean esBestseller() {
        return (2024 - anioPublicacion) <= 2 && precioBase > 30000;
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

    public String getGenero() {
        return genero;
    }
}