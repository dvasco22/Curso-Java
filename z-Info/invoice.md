# Ejercicio de Programación Orientada a Objetos (OOP) en Java: Invoice

Usando OOP, definir un objeto que almacena una factura. Todas las propiedades se definen como privadas.

Las facturas están formadas por la información de la propia empresa (nombre de la empresa, dirección, teléfono, NIF), la información del cliente (similar a la de la empresa), una lista de elementos (cada uno de los cuales dispone de descripción, precio, cantidad) y otra información básica de la factura (importe total, tipo de IVA, forma de pago).

Se incluyen 2 métodos públicos 1) calcula el importe total de la factura y actualice el valor de la propiedad correspondiente. 2) muestre por pantalla el importe total de la factura. Opción: el primero de los métodos puede redefinirse como privado.

## Desarrollo del ejercicio

- La empresa emisora de la factura se define como static: un objeto de la clase Empresa, que incluye propiedades como nombre, dirección, teléfono y NIF.

- Al crear la factura se inyectan como valores:

  - Cliente (objeto de la clase Cliente, con propiedades similares a las de la empresa)
  - un producto y su cantidad
  - el iva base a aplicar (número decimal)
  - la forma de pago como Enum que admitirá valores como "tarjeta", "transferencia", "efectivo", etc.

- Internamente se generan las siguientes propiedades:
  - Número de factura (número entero)
  - Fecha de emisión (objeto de la clase Date)

El método add item permite añadir productos a la factura, que se definen como objetos de la clase Item, que incluye las propiedades:

- Producto (objeto de la clase Producto, con propiedades como nombre, descripción, precio y cantidad)
- Cantidad (número entero)

## Desarrollo extenso del ejercicio

[1]. Empresa y productos

- Creación de la empresa como objetos de la clase Empresa, que incluye las propiedades:
  - nombre
  - dirección
  - teléfono
  - NIF.
- El objeto empresa incluye la lista de productos que vende: objetos de la clase Producto, que incluyen las propiedades:
  - nombre
  - descripción
  - precio
  - cantidad disponible
- El método addProducto permite añadir productos a la lista de productos de la empresa.
- La propiedad clientes de la empresa es una lista de objetos de la clase Cliente, que incluye las propiedades:
  - nombre
  - dirección
  - teléfono
  - NIF

[2] Factura

- La clase Factura incluye las propiedades:
  - empresa que la emite (objeto de la clase Empresa)
  - cliente al que va dirigida (objeto de la clase Cliente)
  - número de factura
  - fecha de emisión
  - lista de elementos (lista de objetos de la clase Item)
  - importe total
  - tipo de IVA
  - forma de pago

La factura se crea desde la empresa, seleccionando un cliente entre los que tiene registrados

Uno de sus métodos permite añadir productos de la lista items a partir de los productos de la empresa.

- La clase Item incluye las propiedades:
  - producto (objeto de la clase Producto)
  - cantidad
  - (precio unitario, ya incluido en producto)
  - importe (calculado como cantidad \* precio unitario)

[3] Métodos de la factura

- El método privado calcula el importe total de la factura, sumando los importes de todos los items.
- El método público muestra el importe total de la factura por pantalla.
- El método público addItem permite añadir un item a la lista de items de la factura, calculando el importe del item y actualizando el importe total de la factura.
- El método público getFacturaInfo devuelve un resumen de la factura, incluyendo la información de la empresa, del cliente, los items y el importe total.
