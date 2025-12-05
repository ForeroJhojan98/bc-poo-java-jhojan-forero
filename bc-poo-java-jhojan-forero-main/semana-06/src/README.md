# 📚 Semana 6 — Implementación de Interfaces y Clases Concretas

En esta semana se desarrolló la implementación completa del dominio aplicando **clases abstractas**, **interfaces**, **polimorfismo** y **clases concretas** dentro del contexto del proyecto de una Librería.

---

# 🎯 Objetivo de la Semana

El objetivo principal fue agregar **comportamientos específicos** a los productos de la librería utilizando **interfaces**, a la vez que se extiende la estructura base utilizando una **clase abstracta común**.

Esto permitió:

- Organizar mejor el dominio.
- Evitar duplicación de código.
- Definir capacidades específicas de cada producto.
- Aplicar polimorfismo y diseño orientado a interfaces.

---

# 🧩 Contenido desarrollado

Durante esta semana se implementaron las siguientes piezas:

## ✔️ 1. Clase abstracta
### `Producto`
Base común para todos los productos, incluye:
- Título
- Autor
- Precio
- Código
- Método abstracto `mostrarInfo()`

---

## ✔️ 2. Interfaces creadas

### `Descuentable`
- `double aplicarDescuento(double porcentaje)`

### `Vendible`
- `void vender()`
- `double calcularPrecioFinal()`

### `Prestable`
- `void prestar()`
- `void devolver()`

Cada interfaz representa un **comportamiento específico**, no ligado a la jerarquía de herencia.

---

## ✔️ 3. Clases concretas implementadas

### **📘 LibroFisico**
- Hereda de `Producto`
- Implementa: `Descuentable`, `Vendible`, `Prestable`
- Es el producto con más funcionalidades: se vende, presta y tiene descuentos.

### **📗 LibroDigital**
- Hereda de `Producto`
- Implementa: `Vendible`, `Descuentable`
- No se presta (coherente con productos digitales)
- Incluye atributos:
    - `pesoMB`
    - `formato`

### **📰 Revista**
- Hereda de `Producto`
- Implementa `Vendible`
- No tiene descuento ni es prestable.

---

# ⚙️ Polimorfismo aplicado

En esta semana se aplicaron dos tipos de polimorfismo:

### ✔️ Polimorfismo por herencia
```java
Producto p = new LibroDigital(...);
p.mostrarInfo();
