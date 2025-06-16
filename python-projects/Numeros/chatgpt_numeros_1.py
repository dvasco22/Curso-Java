import tensorflow as tf
from tensorflow.keras.datasets import mnist
import numpy as np
import matplotlib.pyplot as plt

im = 5  #numeros de imagenes a predecir y mostrar

# 1. Cargar datos
(x_train, y_train), (x_test, y_test) = mnist.load_data()

# 2. Normalizar los datos (escala de 0 a 1)
x_train = x_train / 255.0
x_test = x_test / 255.0

# 3. Añadir una dimensión de canal (de (28,28) a (28,28,1))
x_train = x_train[..., tf.newaxis]
x_test = x_test[..., tf.newaxis]

# 4. Crear el modelo
model = tf.keras.Sequential([
    tf.keras.layers.Flatten(input_shape=(28,28,1)),
    tf.keras.layers.Dense(64, activation='relu'),
    tf.keras.layers.Dense(64, activation='relu'),
    tf.keras.layers.Dense(10, activation='softmax')
])

# 5. Compilar el modelo
model.compile(optimizer='adam',
              loss='sparse_categorical_crossentropy',
              metrics=['accuracy'])

# 6. Entrenar el modelo

print("\n\033[33m" + "Entrenando el Modelo..." + "\033[0m")
model.fit(x_train, y_train, epochs=5, validation_data=(x_test, y_test))
print("\033[33m" + "Modelo Entrenado!!!" + "033[0m")

# # 7. Evaluar el modelo
test_loss, test_accuracy = model.evaluate(x_test, y_test)

print("Pérdida en test:", test_loss)
print("Precisión en test:", test_accuracy)



# Predecimos las clases de las primeras im imágenes del test
#np.argmax(pred) selecciona el índice de la clase con mayor probabilidad 


predicciones = model.predict(x_test[:im])

# Mostramos la clase predicha para cada imagen
for i, pred in enumerate(predicciones):
    clase_predicha = np.argmax(pred)
    print(f"Imagen {i+1}: modelo predice -> {clase_predicha}, etiqueta real -> {y_test[i]}")
    
#visualizar las im primeras imagenes con matplotlib
for i in range(0, im):
    plt.imshow(x_test[i].reshape(28, 28), cmap='gray')
    plt.title(f"Etiqueta real: {y_test[i]}") 
    plt.show()


#Guardar el modelo completo (estructura + pesos + optimizador)
model.save('model.h5')  # guarda como archivo HDF5


#from tensorflow.keras.models import load_model
#modelo_cargado = load_model('mi_modelo_mnist.h5')

# Ahora puedes usar modelo_cargado como si fuera el original
#modelo_cargado.evaluate(x_test, y_test)