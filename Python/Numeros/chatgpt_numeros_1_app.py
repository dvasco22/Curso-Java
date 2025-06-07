
#http://127.0.0.1:7860

import tensorflow as tf
import gradio as gr
import numpy as np

# Cargar el modelo
model = tf.keras.models.load_model("mi_modelo_mnist.h5")

def reconocer_digito(dibujo):
    try:
        # Verificar y extraer la imagen compuesta (lo visible)
        if isinstance(dibujo, dict) and "composite" in dibujo:
            imagen = dibujo["composite"]
        else:
            return "❌ Error: Formato de imagen inesperado", None

        # Asegurar que tiene 3 dimensiones (H, W, C)
        if imagen.ndim == 2:
            imagen = np.expand_dims(imagen, axis=-1)  # (280, 280, 1)

        # Redimensionar a 28x28
        imagen = tf.image.resize(imagen, (28, 28)).numpy()

        # Normalizar e invertir colores (fondo blanco → negro)
        imagen = 1.0 - (imagen / 255.0)

        # Expandir dimensiones para predicción: (1, 28, 28, 1)
        procesada = np.expand_dims(imagen, axis=0)

        # Hacer predicción
        prediccion = model.predict(procesada, verbose=0)[0]
        resultado = {str(i): float(prediccion[i]) for i in range(10)}

        return resultado, imagen.squeeze()
    except Exception as e:
        return f"❌ Error: {str(e)}", None

# Interfaz Gradio
interfaz = gr.Interface(
    fn=reconocer_digito,
    inputs=gr.Sketchpad(image_mode="L", width=280, height=280, label="✏️ Dibuja un número (0-9)"),
    outputs=[
        gr.Label(num_top_classes=3, label="🔢 Predicción"),
        gr.Image(image_mode="L", label="🖼 Imagen procesada (28x28)")
    ],
    title="🧠 Clasificador de Dígitos MNIST",
    description="Dibuja un número del 0 al 9"
)

interfaz.launch()