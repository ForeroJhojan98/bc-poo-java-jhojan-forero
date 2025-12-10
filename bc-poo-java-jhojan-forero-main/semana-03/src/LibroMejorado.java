import java.util.Objects;

/**
 * Clase LibroMejorado - Encapsulación completa con validaciones
 * Representa un libro en la librería "Mundo del Libro"
 */
public class LibroMejorado {

    // ========== ATRIBUTOS PRIVADOS ==========
    private String isbn;
    private String titulo;
    private String autor;
    private double precioVenta;
    private int stockDisponible;
    private boolean esNovedad;
    private String genero;
    private int paginas;

    // ========== CONSTRUCTORES (3 TOTAL) ==========

    /**
     * Constructor 1: Completo (máxima información)
     */
    public LibroMejorado(String isbn, String titulo, String autor,
                         double precioVenta, int stockInicial,
                         String genero, int paginas) {
        setIsbn(isbn);
        setTitulo(titulo);
        setAutor(autor);
        setPrecioVenta(precioVenta);
        setStockDisponible(stockInicial);
        setGenero(genero);
        setPaginas(paginas);
        this.esNovedad = true; // Por defecto nuevo libro es novedad
    }

    /**
     * Constructor 2: Intermedio (sin género ni páginas)
     */
    public LibroMejorado(String isbn, String titulo, String autor,
                         double precioVenta, int stockInicial) {
        this(isbn, titulo, autor, precioVenta, stockInicial,
                "Sin género especificado", 0);
    }

    /**
     * Constructor 3: Básico (solo datos esenciales)
     */
    public LibroMejorado(String isbn, String titulo, double precioVenta) {
        this(isbn, titulo, "Autor Desconocido", precioVenta, 0);
    }

    // ========== GETTERS (TODOS LOS ATRIBUTOS) ==========

    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public double getPrecioVenta() { return precioVenta; }
    public int getStockDisponible() { return stockDisponible; }
    public boolean isEsNovedad() { return esNovedad; }
    public String getGenero() { return genero; }
    public int getPaginas() { return paginas; }

    // ========== SETTERS CON VALIDACIONES ==========

    public void setIsbn(String isbn) {
        Objects.requireNonNull(isbn, "ISBN no puede ser nulo");
        if (isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN no puede estar vacío");
        }
        if (!validarFormatoISBN(isbn)) {
            throw new IllegalArgumentException("Formato ISBN inválido");
        }
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        Objects.requireNonNull(titulo, "Título no puede ser nulo");
        if (titulo.trim().length() < 2) {
            throw new IllegalArgumentException("Título muy corto (mínimo 2 caracteres)");
        }
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        Objects.requireNonNull(autor, "Autor no puede ser nulo");
        this.autor = autor;
    }

    public void setPrecioVenta(double precioVenta) {
        if (precioVenta < 0) {
            throw new IllegalArgumentException("Precio no puede ser negativo");
        }
        if (precioVenta > 1000000) {
            throw new IllegalArgumentException("Precio excesivo (máximo $1,000,000)");
        }
        this.precioVenta = precioVenta;
    }

    public void setStockDisponible(int stockDisponible) {
        if (stockDisponible < 0) {
            throw new IllegalArgumentException("Stock no puede ser negativo");
        }
        if (stockDisponible > 10000) {
            throw new IllegalArgumentException("Stock excesivo (máximo 10,000 unidades)");
        }
        this.stockDisponible = stockDisponible;
    }

    public void setEsNovedad(boolean esNovedad) {
        this.esNovedad = esNovedad;
    }

    public void setGenero(String genero) {
        this.genero = (genero == null) ? "Sin género" : genero;
    }

    public void setPaginas(int paginas) {
        if (paginas < 0) {
            throw new IllegalArgumentException("Número de páginas no puede ser negativo");
        }
        if (paginas > 5000) {
            throw new IllegalArgumentException("Número de páginas excesivo (máximo 5,000)");
        }
        this.paginas = paginas;
    }

    // ========== MÉTODOS PÚBLICOS ==========

    public double calcularPrecioConDescuento(double porcentajeDescuento) {
        if (porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            throw new IllegalArgumentException("Descuento debe estar entre 0 y 100%");
        }
        return precioVenta * (1 - porcentajeDescuento / 100);
    }

    public boolean vender(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad a vender debe ser positiva");
        }
        if (stockDisponible >= cantidad) {
            stockDisponible -= cantidad;
            return true;
        }
        return false;
    }

    public void mostrarDetalles() {
        System.out.println("\n=== DETALLES DEL LIBRO ===");
        System.out.println("ISBN: " + isbn);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Precio: $" + precioVenta);
        System.out.println("Stock: " + stockDisponible + " unidades");
        System.out.println("Género: " + genero);
        System.out.println("Páginas: " + paginas);
        System.out.println("Novedad: " + (esNovedad ? "SÍ" : "NO"));
    }

    // ========== MÉTODOS PRIVADOS AUXILIARES ==========

    private boolean validarFormatoISBN(String isbn) {
        // Validación básica de formato ISBN
        return isbn.matches("\\d{3}-\\d{1,5}-\\d{1,7}-\\d{1,7}-\\d");
    }

    private boolean esPrecioEspecial() {
        return precioVenta > 100000;
    }
}
