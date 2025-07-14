package local.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// De la clase Collections en Java heredan las clases
// que constituyen la API de colecciones de Java:
// - List
//      - ArrayList
//      - LinkedList
//      - Vector
//      - Stack
// - Queue
//      - Deque
//          - ArrayDeque
// - Set
//      - HashSet
//      - LinkedHashSet
//      - TreeSet
// - Map (No hereda de Collection) 
//      - HashMap
//      - TreeMap

public class Demo01Collection {

    @SuppressWarnings("rawtypes")
    public void showCollection(Collection collection) {
        // Mostrar ejemplos de las clases de la API de colecciones
        // como ArrayList, LinkedList, siempre que implementen el interface Collection.

        /*
         * Los principales métodos de la interfaz Collection son:
         * - add(E e): Añade un elemento a la colección.
         * - addAll(Collection<? extends E> c): Añade todos los elementos de otra
         * - remove(Object o): Elimina un elemento de la colección.
         * - removeAll(Collection<?> c): Elimina todos los elementos de otra colección.
         * - retainAll(Collection<?> c): Retiene solo los elementos que están en otra
         * colección.
         * - size(): Devuelve el número de elementos en la colección.
         * - isEmpty(): Comprueba si la colección está vacía.
         * - contains(Object o): Comprueba si un elemento está en la colección.
         * - containsAll(Collection<?>c):
         * Comprueba si la colección contiene todos los elementos de otra colección.
         * - clear(): Elimina todos los elementos de la colección.
         * - iterator(): Devuelve un iterador para recorrer la colección.
         * - toArray(): Convierte la colección en un array.
         * - stream(): Devuelve un flujo (stream) para procesar
         * los elementos de la colección de manera funcional.
         */

        System.out.println("Collection: " + collection.getClass().getSimpleName());
        System.out.println("Size: " + collection.size());
        System.out.println("Elements: " + collection);
        System.out.println("Is empty: " + collection.isEmpty());

        for (Object element : collection) {
            System.out.println("Element: " + element);
        }

    }

    public static void main(String[] args) {
        Demo01Collection app = new Demo01Collection();

        // Ejemplo de uso con una colección concreta
        // Aquí se puede usar cualquier implementación de Collection,
        // como ArrayList, LinkedList, etc.
        // Por ejemplo, usando ArrayList:
        List<String> list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");

        app.showCollection(list);

        // También se puede usar Queue, Set, etc.
        // Por ejemplo, usando una LinkedList:
        Deque<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            linkedList.add(i);
        }

        app.showCollection(linkedList);

        // También se puede usar un Set, como HashSet:
        Set<Character> set = new HashSet<>();
        String str = "collection";
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        app.showCollection(set);
    }

}