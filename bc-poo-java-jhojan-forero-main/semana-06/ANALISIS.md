# 📘 ANÁLISIS — Semana 6
## Implementación de Interfaces y Herencia en el Dominio de Librería

En esta semana se integran **interfaces**, **clases abstractas** y **clases concretas** para modelar correctamente el funcionamiento de los productos de una librería.  
El objetivo es aplicar **POO avanzada**, enfocada en **polimorfismo**, **interfaces múltiples**, **sobrescritura** y **coherencia del dominio**.

---

# 1. ✔️ Clases abstractas

### `Producto`
Es la base de todo producto dentro de la librería.  
Contiene atributos generales:

- `String titulo`
- `String autor`
- `double precio`
- `String codigo`

Métodos definidos:
- Getters y setters
- Método abstracto `mostrarInfo()`: obligado para todas las subclases.

**Razón:** Permite que todos los productos compartan estructura, pero cada uno defina su propio comportamiento.

---

# 2. ✔️ Interfaces implementadas

### `Descuentable`
Permite aplicar descuentos sobre el precio.
Método:
- `double aplicarDescuento(double porcentaje)`

### `Vendible`
Permite manejar el proceso de venta.
Métodos:
- `void vender()`
- `double calcularPrecioFinal()`

### `Prestable`
Modelo para objetos que se pueden prestar.
Métodos:
- `void prestar()`
- `void devolver()`

**Razón:**  
Las interfaces permiten definir capacidades que **no dependen de la herencia**, sino del comportamiento específico.  
Un producto puede ser prestable, vendible, ambas o ninguna.

---

# 3. ✔️ Clases concretas (implementaciones)

## 3.1 `LibroFisico`
Hereda de `Producto` e implementa:

- `Vendible`
- `Prestable`
- `Descuentable`

Acciones clave:
- Soporta venta.
- Se puede prestar.
- Soporta descuentos.
- Sobrescribe `mostrarInfo()`.

Esto lo convierte en el producto “más completo”.

---

## 3.2 `LibroDigital`
Hereda de `Producto` e implementa:

- `Vendible`
- `Descuentable`

Razón:
- Un libro digital **no se presta**, solo se vende y aplica descuento.

Incluye atributos propios:
- `double pesoMB`
- `String formato`

---

## 3.3 `Revista`
Hereda de `Producto` e implementa únicamente:

- `Vendible`

Razón:
- Las revistas normalmente no se prestan.
- No siempre tienen descuento para mantener coherencia del dominio.

---

# 4. ✔️ Polimorfismo aplicado

Gracias a la herencia + interfaces se logra:

### 🎯 Polimorfismo por herencia:
`Producto producto = new LibroDigital(...);`

El método `mostrarInfo()` funciona distinto según el objeto.

### 🎯 Polimorfismo por interfaces:
```java
Vendible v = new LibroFisico(...);
v.vender();
