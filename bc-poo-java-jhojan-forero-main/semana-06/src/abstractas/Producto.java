package abstractas;

public abstract class Producto {
    protected String titulo;
    protected String autor;
    protected String codigo;
    protected int anioPublicacion;


    public Producto(String titulo, String autor, String codigo, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
        this.anioPublicacion = anioPublicacion;
    }


    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getCodigo() { return codigo; }
    public int getAnioPublicacion() { return anioPublicacion; }


    public abstract String obtenerDescripcion();
}
