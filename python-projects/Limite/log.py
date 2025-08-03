import numpy as np
import matplotlib.pyplot as plt

# Crear valores de x (x > 0, porque log(x) no está definida para x <= 0)
x = np.linspace(0.1, 10, 400)  # desde 0.1 para evitar log(0)
y = np.log(x)

# Crear la gráfica
plt.figure(figsize=(8, 6))
plt.plot(x, y, label='f(x) = log(x)', color='green')

# Agregar líneas de los ejes
plt.axhline(0, color='black', linewidth=0.8)
plt.axvline(0, color='black', linewidth=0.8)

# Etiquetas y detalles
plt.title('Gráfica de f(x) = log(x)')
plt.xlabel('x')
plt.ylabel('f(x)')
plt.grid(True)
plt.legend()

# Mostrar la gráfica
plt.show()


