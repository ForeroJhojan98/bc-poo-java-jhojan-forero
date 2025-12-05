package implementaciones;

import abstractas.Producto;
import interfaces.Descuentable;
import interfaces.Vendible;

public class LibroDigital extends Producto implements Vendible, Descuentable {


    private double tamanoMB;
    private String formato;


    public LibroDigital(String titulo, String autor, String codigo, int anioPublicacion,
                        double tamanoMB, String formato) {
        super(titulo, autor, codigo, anioPublicacion);
        this.tamanoMB = tamanoMB;
        this.formato = formato;
    }


    @Override
    public double calcularPrecio() {
        return 15000;
    }


    @Override
    public double aplicarDescuento(double porcentaje) {
        return calcularPrecio() * (1 - porcentaje / 100);
    }


    @Override
    public String obtenerDescripcion() {
        return "Libro Digital: " + titulo + " | Formato: " + formato +
                " | Tamaño: " + tamanoMB + "MB";
    }
}