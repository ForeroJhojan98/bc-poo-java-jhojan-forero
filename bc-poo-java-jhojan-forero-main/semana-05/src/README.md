# Análisis de Polimorfismo - Librería "Mundo del Libro"

## 1. Objetivo de la Semana
Implementar **polimorfismo** en el sistema de la librería mediante:
- ✅ **Sobrecarga de métodos** (Overloading): mismo nombre, diferentes parámetros
- ✅ **Sobrescritura de métodos** (Overriding): comportamiento específico por subclase
- ✅ **Polimorfismo dinámico**: vinculación en tiempo de ejecución
- ✅ **ArrayList polimórfico**: colección que almacena diferentes tipos

## 2. Clases Implementadas

### **Clase Padre: Producto (Mejorada)**
**Clase Implementada:** `Producto.java` (ahora abstracta)

**Cambios principales respecto a Semana 4:**
- Convertida a **clase abstracta** para forzar polimorfismo
- **3 métodos abstractos** que deben ser implementados por subclases:
    - `calcularPrecioFinal()` → Precio con descuentos e impuestos específicos
    - `obtenerDescripcionDetallada()` → Descripción según tipo de producto
    - `aplicarDescuentoEspecial(double)` → Descuento con reglas específicas

### **Subclase 1: Libro (Con @Override)**
**Clase Implementada:** `Libro.java` (extiende Producto)

**Métodos sobrescritos (@Override):**
- `calcularPrecioFinal()`: Aplica **5% descuento promocional + 19% IVA**
- `obtenerDescripcionDetallada()`: Incluye **autor, editorial, ISBN, año, género**
- `aplicarDescuentoEspecial(double)`: Añade **descuento por antigüedad** del libro

**Métodos específicos nuevos:**
- `calcularDescuentoPorAntiguedad()`: Calcula descuento adicional según años de publicación
- `esBestseller()`: Determina si es bestseller según precio y antigüedad

### **Subclase 2: ProductoPapeleria (Con @Override)**
**Clase Implementada:** `ProductoPapeleria.java` (extiende Producto)

**Métodos sobrescritos (@Override):** (COMPORTAMIENTO DIFERENTE a Libro)
- `calcularPrecioFinal()`: Aplica **10% descuento promocional + 19% IVA**
- `obtenerDescripcionDetallada()`: Incluye **tipo, marca, material, garantía**
- `aplicarDescuentoEspecial(double)`: Añade **descuento por tipo** (escolar, oficina, artes)

**Métodos específicos nuevos:**
- `calcularDescuentoTipo()`: Descuento según categoría (15% escolar, 10% oficina, 20% artes)
- `esEcologico()`: Verifica si el material es amigable con el medio ambiente

### **Clase Gestora: SistemaPolimorfico (Nueva)**
**Clase Implementada:** `SistemaPolimorfico.java`

**Implementa SOBRECARGA (Overloading):**
1. `agregarProducto(Producto producto)` → Producto básico
2. `agregarProducto(Producto producto, int cantidadInicial)` → Con stock inicial
3. `agregarProducto(ArrayList<Producto> productos)` → Múltiples productos
4. `buscarProducto(String codigo)` → Por código único
5. `buscarProductoPorNombre(String nombre)` → Por coincidencia de nombre
6. `buscarProducto(double precioMin, double precioMax)` → Por rango de precio

**Implementa métodos POLIMÓRFICOS:**
- `procesarProducto(Producto producto)`: Procesa cualquier producto (Libro o Papelería)
- `calcularValorTotal(Producto producto, int cantidad)`: Calcula valor para cualquier producto
- `venderProducto(Producto producto, int cantidad)`: Vende cualquier producto

## 3. Demostración de Polimorfismo en Main.java

### **ArrayList Polimórfico:**
```java
// Puede contener Libros Y ProductoPapeleria
ArrayList<Producto> inventario = new ArrayList<>();
inventario.add(new Libro(...));          // ✅ Subclase 1
inventario.add(new ProductoPapeleria(...)); // ✅ Subclase 2