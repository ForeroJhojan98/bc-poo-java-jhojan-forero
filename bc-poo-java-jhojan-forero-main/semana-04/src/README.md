# Análisis de Herencia y Polimorfismo - Librería "Mundo del Libro"

## 1. Identificación de la Jerarquía

**Jerarquía identificada:** Sistema de Productos de la librería  
**Justificación:** Todos los productos de venta (libros, papelería, material didáctico) comparten características comunes como precio, stock y código, pero tienen atributos específicos según su tipo.

## 2. Clases Implementadas

### **Clase Padre: Producto**
**¿Qué es?:** Clase base que representa cualquier artículo disponible para venta en la librería.  
**Clase Implementada:** `Producto.java`

**Atributos protected (compartidos con subclases):**
- `codigo: String` - Identificador único del producto en el sistema.
- `nombre: String` - Nombre comercial del producto.
- `precioBase: double` - Precio de venta sin impuestos.
- `stock: int` - Cantidad de unidades disponibles en inventario.

**Métodos heredables:**
- `mostrarInfo(): void` - Muestra información básica del producto.
- `calcularPrecioConIVA(): double` - Calcula precio final con IVA (19%).
- `vender(int cantidad): boolean` - Procesa venta de unidades.
- `reponerStock(int cantidad): void` - Añade unidades al inventario.

### **Subclase 1: Libro**
**¿Qué es?:** Producto específico que representa libros de cualquier género.  
**Clase Implementada:** `Libro.java` (hereda de `Producto`)

**Atributos específicos añadidos:**
- `isbn: String` - Identificador único internacional para libros.
- `autor: String` - Nombre del autor de la obra.
- `editorial: String` - Casa editorial que publica el libro.
- `anioPublicacion: int` - Año de primera publicación.

**Métodos sobrescritos (@Override):**
- `mostrarInfo(): void` - Muestra información completa del libro (incluye ISBN, autor, editorial).
- `vender(int cantidad): boolean` - Añade validación especial para libros antiguos.

**Métodos específicos nuevos:**
- `calcularAntiguedad(): int` - Calcula años desde su publicación.
- `esBestseller(): boolean` - Determina si es un libro bestseller según reglas de negocio.

### **Subclase 2: ProductoPapeleria**
**¿Qué es?:** Producto específico que representa artículos de papelería y útiles escolares.  
**Clase Implementada:** `ProductoPapeleria.java` (hereda de `Producto`)

**Atributos específicos añadidos:**
- `tipo: String` - Categoría (ESCOLAR, OFICINA, ARTES, ESCRITURA).
- `marca: String` - Marca comercial del producto.
- `material: String` - Material principal de fabricación.
- `garantiaMeses: int` - Meses de garantía ofrecidos.

**Métodos sobrescritos (@Override):**
- `mostrarInfo(): void` - Muestra información completa de papelería (incluye tipo, marca, material).
- `vender(int cantidad): boolean` - Añade validación para productos ecológicos.

**Métodos específicos nuevos:**
- `calcularDescuentoTipo(): double` - Calcula descuento según el tipo de producto.
- `esEcologico(): boolean` - Verifica si el producto es amigable con el medio ambiente.

## 3. Relaciones de Herencia

**Tipo de relación:** Herencia Jerárquica.

**Descripción:**
- La clase `Producto` actúa como clase padre/base.
- Las clases `Libro` y `ProductoPapeleria` extienden (heredan de) `Producto`.
- Cada subclase añade atributos y comportamientos específicos mientras mantiene los generales.

**Uso de `super()` en constructores:**
```java
// En Libro.java
public Libro(...) {
    super(codigo, nombre, precioBase, stock); // Llama constructor padre
    // ... inicialización específica de Libro
}