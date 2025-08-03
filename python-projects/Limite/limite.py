import matplotlib.pyplot as plt
import numpy as np
import matplotlib.patches as patches

# Definimos la función
def f(x):
    return 3 * x + 1

# Valores para graficar
x = np.linspace(0, 4, 400)
y = f(x)

# Punto de interés
a = 2
L = f(a)

# Valores épsilon y delta
epsilon = 1
delta = epsilon / 3

# Crear la figura
fig, ax = plt.subplots(figsize=(8, 6))

# Graficar la función
ax.plot(x, y, label="f(x) = 3x + 1", color="blue")

# Líneas horizontales ε
ax.axhline(L + epsilon, color='red', linestyle='--', label=r"$L \pm \varepsilon$")
ax.axhline(L - epsilon, color='red', linestyle='--')

# Líneas verticales δ
ax.axvline(a - delta, color='green', linestyle='--', label=r"$a \pm \delta$")
ax.axvline(a + delta, color='green', linestyle='--')

# Punto límite
ax.plot(a, L, 'ko', label="Límite (a, L)")

# Banda horizontal (ε)
ax.add_patch(patches.Rectangle((x[0], L - epsilon), x[-1] - x[0], 2 * epsilon,
                               facecolor='red', alpha=0.1))

# Banda vertical (δ)
ax.add_patch(patches.Rectangle((a - delta, ax.get_ylim()[0]), 2 * delta,
                               ax.get_ylim()[1] - ax.get_ylim()[0],
                               facecolor='green', alpha=0.1))

# Etiquetas
ax.set_title("Visualización de la definición formal de límite")
ax.set_xlabel("x")
ax.set_ylabel("f(x)")
ax.legend()
ax.grid(True)

plt.show()
