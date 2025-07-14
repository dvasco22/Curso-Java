package local.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

// Las listas son colecciones ordenadas de elementos que permiten
// almacenar elementos de manera secuencial. 
// A diferencia de los conjuntos,
// las listas pueden contener elementos duplicados y mantienen el orden de inserción.

// - List
//      - ArrayList
//      - LinkedList
//      - Vector
//          - Stack

public class Demo02List {

    public void showList(List<Integer> list) {
        // Mostrar ejemplos de las clases de la API de colecciones
        // como ArrayList, LinkedList, siempre que implementen el interface List.

        /*
         * Los principales métodos de la interfaz List son: - get(int index): Obtiene el
         * elemento en la posición especificada. - set(int index, E element): Reemplaza
         * el elemento en la posición especificada. - indexOf(Object o): Devuelve el
         * índice del primer elemento igual al especificado. - lastIndexOf(Object o):
         * Devuelve el índice del último elemento igual al especificado.
         */

        System.out.println("----------------------------------------------------------");
        System.out.println("List: " + list.getClass().getSimpleName());
        System.out.println("Size: " + list.size());
        System.out.println("Elements: " + list);
        System.out.println("Is empty: " + list.isEmpty());

        for (Object element : list) {
            System.out.println("Element: " + element);
        }

        list.set(1, 200); // Reemplaza el primer elemento con 100

        System.out.println("Elemento 1: " + list.get(1)); // Acceso al segundo elemento
        System.out.println("Índice del elemento de valor  30: " + list.indexOf(30)); // Índice del primer elemento igual
                                                                                     // a 3
        System.out.println("Último índice del elemento de valor  30: " + list.lastIndexOf(30)); // Índice del último

        System.out.println("Elements: " + list);// elemento
    }

    public static void main(String[] args) {
        // Aquí puedes crear instancias de las clases que implementan List
        // como ArrayList, LinkedList, etc., y probar sus métodos.

        // Ejemplo de uso de ArrayList
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> vector = new Vector<>();
        List<Integer> stack = new Stack<>();

        for (int i = 10; i <= 50; i = i + 10) {

            // Añadir elementos a las listas
            // Estos métodos son comunes a todas las implementaciones de List.
            // Puedes usar add(E e) para añadir un elemento al final de la lista.
            // También puedes usar add(int index, E element) para añadir en una posición
            // específica.

            arrayList.add(i);
            linkedList.add(i);
            vector.add(i);
            stack.add(i);
        }

        Demo02List demo = new Demo02List();
        demo.showList(arrayList);
        demo.showList(linkedList);
        demo.showList(vector);
        demo.showList(stack);

        // Ejemplo de uso de LinkedList
        // LinkedList es una implementación de lista basada en nodos enlazados.
        // Permite añadir y eliminar elementos de manera eficiente en ambos extremos.

    }

}