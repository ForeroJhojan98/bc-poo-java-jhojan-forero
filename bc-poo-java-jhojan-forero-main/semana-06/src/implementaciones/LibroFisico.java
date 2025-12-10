package implementaciones;


import abstractas.Producto;
import interfaces.Prestable;
import interfaces.Vendible;

public class LibroFisico extends Producto implements Vendible, Prestable {


    private int paginas;
    private double pesoGr;


    public LibroFisico(String titulo, String autor, String codigo, int anioPublicacion,
                       int paginas, double pesoGr) {
        super(titulo, autor, codigo, anioPublicacion);
        this.paginas = paginas;
        this.pesoGr = pesoGr;
    }


    @Override
    public double calcularPrecio() {
        return 30000;
    }


    @Override
    public void prestar() {
        System.out.println("Libro Físico prestado: " + titulo);
    }


    @Override
    public void devolver() {
        System.out.println("Libro Físico devuelto: " + titulo);
    }


    @Override
    public String obtenerDescripcion() {
        return "Libro Físico: " + titulo +
                " | Páginas: " + paginas +
                " | Peso: " + pesoGr + "g";
    }
}