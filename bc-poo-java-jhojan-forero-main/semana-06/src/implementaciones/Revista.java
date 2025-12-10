package implementaciones;


import abstractas.Producto;
import interfaces.Vendible;

public class Revista extends Producto implements Vendible {


    private int numeroEdicion;
    private String categoria;


    public Revista(String titulo, String autor, String codigo, int anioPublicacion,
                   int numeroEdicion, String categoria) {
        super(titulo, autor, codigo, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
        this.categoria = categoria;
    }


    @Override
    public double calcularPrecio() {
        return 8000;
    }


    @Override
    public String obtenerDescripcion() {
        return "Revista: " + titulo +
                " | Edición: " + numeroEdicion +
                " | Categoría: " + categoria;
    }
}