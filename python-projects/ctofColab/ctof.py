#https://www.youtube.com/watch?v=iX_on3VxZzk
#python -m http.server 8000
#http://localhost:8000/index2.html
#tensorflowjs_converter --input_format keras --output_format ctof.h5 ./


# Este ejemplo es clásico en TensorFlow para enseñar cómo una red neuronal puede aprender
# relaciones matemáticas simples, como una conversión lineal. esto es 
#
#         F = C * 1.8 + 32  ( y = mx + b)
#
# En el aprendizaje automatico no se conoce la regla de conversion se infiere a partir 
# de entradas y resultados con la finalidad que el modelo aprenda por si solo el algoritmo
# A pesar de que una red neuronal es excesiva para este problema, que se puede predecir
# a través de una recta, sirve como introducción al proceso de entrenamiento y predicción.

#🔹1. Importación de librerías
#     tensorflow: 
#        biblioteca principal para machine learning. Aquí se usa para crear, 
#        entrenar y predecir con redes neuronales.
#     numpy: 
#        se utiliza para manipular arrays numéricos, aunque en este código 
#        solo se usa para hacer una predicción.
#     matplotlib.pyplot: 
#        usada para graficar, en este caso, para visualizar la evolución del 
#        error (pérdida) durante el entrenamiento.
import tensorflow as tf
import numpy as np
import matplotlib.pyplot as plt


#🔹2. Datos de entrenamiento : Se definen dos tensores:
#       celsius: entradas (features)
#       fahrenheit: salidas esperadas (labels)
#     Estos pares representan valores conocidos de conversión de temperaturas. 
#     Son los datos que la red usará para aprender la relación.
celsius = tf.constant([-40, -10, 0, 8, 15, 22, 38], dtype=tf.float32)
fahrenheit = tf.constant([-40, 14, 32, 46.4, 59, 71.6, 100.4], dtype=tf.float32)

#🔹3. Definición del modelo (Red neuronal)
#     Se construye una red neuronal con 3 capas:
#      3.1 Capa oculta-1:    --> capa densa con 3 neuronas y una entrada
#                                units=3: 3 neuronas
#                                input_shape=[1]:  --> entrada temperatura en Celsius)
#      3.2 Capa oculta-2:    --> Otra capa densa con 3 neuronas
#      3.4 Capa de salida:
#          1 neurona (produce un solo valor: la temperatura en Fahrenheit)
#      Sequential indica que las capas están conectadas una tras otra, en orden.
#
# Nota: en el código original hay una versión comentada con una sola capa; 
# aquí se usa una arquitectura más profunda para efectos didácticos o experimentales.

capa = tf.keras.layers.Dense(units=1, input_shape=[1])
modelo = tf.keras.Sequential([capa])
# oculta1 = tf.keras.layers.Dense(units=3, input_shape=[1])
# oculta2 = tf.keras.layers.Dense(units=3)
# salida = tf.keras.layers.Dense(units=1)
# modelo = tf.keras.Sequential([oculta1, oculta2, salida])

#🔹4. Compilación del modelo
#     Optimizador: Adam con tasa de aprendizaje de 0.1. 
#                 Se encarga de actualizar los pesos de la red para reducir el error.
#     Función de pérdida: 'mean_squared_error' 
#                (error cuadrático medio), adecuada para problemas de regresión líneal.
modelo.compile(
    optimizer=tf.keras.optimizers.Adam(0.1),
    loss='mean_squared_error'
)


#🔹5. Entrenamiento del modelo
#     Se entrena el modelo usando los datos por 100 épocas (iteraciones).
#     verbose=False suprime la salida durante el entrenamiento.
#     El historial devuelto contiene información útil como el valor de pérdida por época.
print("Comenzando entrenamiento...")
historial = modelo.fit(celsius, fahrenheit, epochs=1000, verbose=False)
print("Modelo entrenado!")


#🔹6. Visualización del error durante el entrenamiento
#     Se grafica cómo la pérdida disminuye a lo largo de las épocas, 
#     lo cual es una señal de que el modelo está aprendiendo.
#     en este caso a partir de la época 60 el modelo esta completamente entrenado
plt.xlabel("# Epoca")
plt.ylabel("Magnitud de pérdida")
plt.plot(historial.history["loss"])

#🔹7. Predicción
#     Se prueba el modelo con un nuevo valor: 100 grados Celsius.
#     Se imprime la predicción, que debería estar cerca de 212°F (la conversión exacta).
print("Hagamos una predicción!")
resultado = modelo.predict(np.array([100.0]))
print("El resultado es " + str(resultado) + " fahrenheit!")

#🔹8. Inspección de pesos del modelo
#     Se imprimen los pesos y sesgos aprendidos por cada capa, que son los parámetros 
#     ajustados durante el entrenamiento. Esta información muestra cómo internamente 
#     el modelo está representando la relación Celsius → Fahrenheit.
print("Variables internas del modelo")
print(capa.get_weights())
# print(oculta1.get_weights())
# print(oculta2.get_weights())
# print(salida.get_weights())

#Exportar el modelo en formato h5
#modelo.save('celsius_a_fahrenheit.h5')


# 🔷 La tasa de aprendizaje es un valor (por lo general pequeño) que controla el tamaño de los pasos que da el 
# optimizador al ajustar los pesos del modelo durante el entrenamiento.
#
# Fórmula simplificada de actualización:
#     nuevo_peso = peso_actual - tasa_de_aprendizaje × gradiente
#
# 🔹 Una tasa muy pequeña (p. ej. 0.0001) provoca un prendizaje muy estable y preciso pero puede tomar muchas épocas en converger
# Puede quedarse atrapado en mínimos locales si no tiene suficiente impulso.
#
# 🔹Poe el contrario una tasa muy grande (p. ej. 0.1, 0.5 o más) al principio aprende rápido pero puede saltarse el Mínimo oóptimo
#    con riesgo de inestabilidad y las pérdidas oscilan o incluso aumentan.
# Una tasa media conlleva a pasos controlados acelera el proceso de aprendizaje pero sin saltarte el mínimo.





