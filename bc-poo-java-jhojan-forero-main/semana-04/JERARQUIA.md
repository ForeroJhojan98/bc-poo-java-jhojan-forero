# 📊 JERARQUÍA DE CLASES - Semana 04
## 🏪 Sistema de Productos: Librería "Mundo del Libro"

---

---

## 🎯 **Justificación de la Jerarquía**

### **1. ¿Por qué Producto como clase padre?**
**Razones de diseño:**
- **Abstracción natural:** Todos los artículos de venta en una librería SON productos.
- **Atributos comunes:** Código, nombre, precio y stock son compartidos por libros, papelería, material didáctico, etc.
- **Comportamiento común:** Todas las ventas, reposiciones y cálculos de precio con IVA funcionan igual.
- **Cohesión:** Agrupa lo que cambia junto y separa lo que cambia por separado.

### **2. ¿Por qué Libro y ProductoPapeleria como subclases?**
**Diferenciación por especialización:**

| **Aspecto** | **Libro** | **ProductoPapeleria** | **Justificación** |
|------------|-----------|----------------------|-------------------|
| **Identificador único** | ISBN (estándar internacional) | Código interno | Libros necesitan ISBN para venta y catalogación |
| **Atributos clave** | Autor, Editorial, Año | Tipo, Marca, Material | Características inherentes a cada categoría |
| **Cálculos específicos** | Antigüedad, Bestseller | Descuento por tipo, Ecológico | Reglas de negocio diferentes |
| **Proceso de venta** | Validación ediciones especiales | Validación productos ecológicos | Experiencia de compra diferenciada |

---

## 📋 **Atributos Heredados (Protected)**

### **De Producto a todas las subclases:**
```java
// Accesibles directamente en subclases por ser 'protected'
protected String codigo;      // Identificador único en el sistema
protected String nombre;      // Nombre comercial del producto
protected double precioBase;  // Precio sin impuestos
protected int stock;          // Unidades disponibles