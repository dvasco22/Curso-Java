package local.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Demo06Set {

    final String[] ASTROS = { "Mercurio", "Venus", "Tierra", "Marte", "Jupiter", "Saturno", "Urano", "Neptuno" };

    // Los conjuntos (Set) son una colección de elementos únicos, sin orden
    // específico.
    // Implementan la interfaz Collection y no permiten elementos duplicados.

    public void useHashSetAstros() {
        // HashSet es una implementación de Set que utiliza una tabla hash para
        // almacenar los elementos.
        // Permite operaciones rápidas de inserción, eliminación y búsqueda.
        // No garantiza el orden de los elementos.

        HashSet<String> hashSet = new HashSet<>();

        // Añadir elementos
        for (int i = 0; i < ASTROS.length; i++) {
            hashSet.add(ASTROS[i]);
        }

        // Intentar añadir un elemento duplicado
        hashSet.add(ASTROS[0]); // No se añadirá, ya que ya existe

        // Mostrar el HashSet
        System.out.println("HashSet: " + hashSet.getClass().getSimpleName());
        System.out.println("Size: " + hashSet.size());
        System.out.println("Elements: " + hashSet);
    }

    public void useLinkedHashSetAstros() {
        // LinkedHashSet es una implementación de Set que mantiene el orden de
        // inserción.
        // Utiliza una tabla hash y una lista doblemente enlazada para mantener el
        // orden.

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        // Añadir elementos
        for (int i = 0; i < ASTROS.length; i++) {
            linkedHashSet.add(ASTROS[i]);
        }

        // Intentar añadir un elemento duplicado
        linkedHashSet.add(ASTROS[0]); // No se añadirá, ya que ya existe

        // Mostrar el LinkedHashSet
        System.out.println("LinkedHashSet: " + linkedHashSet.getClass().getSimpleName());
        System.out.println("Size: " + linkedHashSet.size());
        System.out.println("Elements: " + linkedHashSet);

    }

    public void useTreeSetAstros() {
        // TreeSet es una implementación de Set que almacena los elementos en orden
        // ascendente.
        // Utiliza un árbol
        // Permite operaciones rápidas de inserción, eliminación y búsqueda.
        // No permite elementos duplicados y no permite elementos nulos.
        // TreeSet es útil cuando se necesita mantener los elementos ordenados.

        TreeSet<String> treeSet = new TreeSet<>();

        // Añadir elementos
        for (int i = 0; i < ASTROS.length; i++) {
            treeSet.add(ASTROS[i]);
        }

        // Intentar añadir un elemento duplicado
        treeSet.add(ASTROS[0]); // No se añadirá, ya que ya existe

        // Mostrar el TreeSet
        System.out.println("TreeSet: " + treeSet.getClass().getSimpleName());
        System.out.println("Size: " + treeSet.size());
        System.out.println("Elements: " + treeSet);
    }

    public static void main(String[] args) {
        Demo06Set demo = new Demo06Set();

        System.out.println("-----------------------------------------------------------");
        System.out.println(Arrays.toString(demo.ASTROS));
        demo.useHashSetAstros();
        System.out.println("Orden aleatorio ----------------------------------");
        demo.useLinkedHashSetAstros();
        System.out.println("Orden de inserción ----------------------------------");
        demo.useTreeSetAstros();
        System.out.println("Orden ascendente ----------------------------------");

    }

}