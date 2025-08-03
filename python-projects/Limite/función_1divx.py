import numpy as np
import matplotlib.pyplot as plt

# Crear los valores de x evitando el 0 (división por cero)
x1 = np.linspace(-10, -0.1, 400)
x2 = np.linspace(0.1, 10, 400)

# Calcular los valores de f(x) = 1/x
y1 = 1 / x1
y2 = 1 / x2

# Crear la figura
plt.figure(figsize=(8, 6))

# Graficar ambas ramas de la función
plt.plot(x1, y1, label='f(x) = 1/x', color='blue')
plt.plot(x2, y2, color='blue')

# Agregar líneas de los ejes
plt.axhline(0, color='black', linewidth=0.8)
plt.axvline(0, color='black', linewidth=0.8)

# Agregar detalles
plt.title('Gráfica de f(x) = 1/x')
plt.xlabel('x')
plt.ylabel('f(x)')
plt.grid(True)
plt.legend()
plt.ylim(-10, 10)

# Mostrar la gráfica
plt.show()
