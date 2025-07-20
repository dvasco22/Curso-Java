package local.collections;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CatalogoConArchivo {
    private static final String ARCHIVO = "catalogo.txt";

    public static void main(String[] args) {
        Map<String, Double> productos = cargarCatalogo();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Ver catálogo");
            System.out.println("2. Consultar precio");
            System.out.println("3. Agregar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("\nCatálogo de productos:");
                    for (Map.Entry<String, Double> entrada : productos.entrySet()) {
                        System.out.println(entrada.getKey() + " - $" + entrada.getValue());
                    }
                    break;

                case 2:
                    System.out.print("Producto a consultar: ");
                    String nombre = scanner.nextLine();
                    if (productos.containsKey(nombre)) {
                        System.out.println("Precio de " + nombre + ": $" + productos.get(nombre));
                    } else {
                        System.out.println("Ese producto no está en el catálogo.");
                    }
                    break;

                case 3:
                    System.out.print("Nombre del nuevo producto: ");
                    String nuevo = scanner.nextLine();
                    System.out.print("Precio de " + nuevo + ": ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine(); // limpiar buffer
                    productos.put(nuevo, precio);
                    guardarCatalogo(productos);
                    System.out.println(nuevo + " agregado al catálogo.");
                    break;

                case 4:
                    System.out.print("Nombre del producto a eliminar: ");
                    String eliminar = scanner.nextLine();
                    if (productos.remove(eliminar) != null) {
                        guardarCatalogo(productos);
                        System.out.println(eliminar + " eliminado.");
                    } else {
                        System.out.println("Ese producto no existe.");
                    }
                    break;

                case 5:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        scanner.close();
        System.out.println("¡Hasta pronto!");
    }

    // Cargar productos desde archivo
    private static Map<String, Double> cargarCatalogo() {
        Map<String, Double> productos = new HashMap<>();
        File archivo = new File(ARCHIVO);

        if (archivo.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(",");
                    if (partes.length == 2) {
                        String nombre = partes[0].trim();
                        double precio = Double.parseDouble(partes[1].trim());
                        productos.put(nombre, precio);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        }

        return productos;
    }

    // Guardar productos en archivo
    private static void guardarCatalogo(Map<String, Double> productos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Map.Entry<String, Double> entrada : productos.entrySet()) {
                bw.write(entrada.getKey() + "," + entrada.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}