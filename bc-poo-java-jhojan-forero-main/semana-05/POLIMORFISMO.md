# 📊 ANÁLISIS DE POLIMORFISMO - Librería "Mundo del Libro"

## 1. SOBRECARGA (Overloading)

### Métodos Sobrecargados Implementados

#### En `SistemaPolimorfico.java`:

| **Método** | **Parámetros** | **Retorno** | **Propósito** |
|------------|----------------|-------------|---------------|
| `agregarProducto(Producto)` | 1 producto | void | Agregar producto básico |
| `agregarProducto(Producto, int)` | producto + cantidad | void | Agregar con stock inicial |
| `agregarProducto(ArrayList<Producto>)` | lista productos | void | Agregar múltiples productos |
| `buscarProducto(String)` | código | Producto | Buscar por código único |
| `buscarProductoPorNombre(String)` | nombre | ArrayList<Producto> | Buscar por coincidencia nombre |
| `buscarProducto(double, double)` | precioMin, precioMax | ArrayList<Producto> | Buscar por rango de precios |

### Ejemplo de Sobrecarga:
```java
// Mismo nombre, diferentes parámetros
public void agregarProducto(Producto producto) {
    inventario.add(producto);
}

public void agregarProducto(Producto producto, int cantidadInicial) {
    producto.reponerStock(cantidadInicial);
    inventario.add(producto);
}

public void agregarProducto(ArrayList<Producto> productos) {
    inventario.addAll(productos);
}