import abstractas.Producto;
import implementaciones.LibroDigital;
import implementaciones.LibroFisico;
import implementaciones.Revista;

public class Main {
    public static void main(String[] args) {


        LibroDigital ld = new LibroDigital("POO en Java", "Jhojan", "LD001", 2024, 5.2, "PDF");
        LibroFisico lf = new LibroFisico("Estructuras de Datos", "Ana", "LF900", 2023, 450, 600);
        Revista rv = new Revista("National Geo", "Varios", "R102", 2025, 88, "Ciencia");


        System.out.println(ld.obtenerDescripcion());
        System.out.println(lf.obtenerDescripcion());
        System.out.println(rv.obtenerDescripcion());


        System.out.println("Precio libro digital con 20%: " + ld.aplicarDescuento(20));
        System.out.println("Precio libro físico: " + lf.calcularPrecio());


        lf.prestar();
        lf.devolver();
    }
}