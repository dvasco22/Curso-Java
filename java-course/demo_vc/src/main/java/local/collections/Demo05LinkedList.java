package local.collections;

import java.util.LinkedList;

public class Demo05LinkedList {

    // Las listas enlazadas son una estructura de datos que consiste en nodos
    // donde cada nodo contiene un valor y una referencia al siguiente nodo.
    // Implementan la interfaz List y la de Deque, que a su vez hereda de Queue .

    // A diferencia de las listas basadas en arrays, las listas enlazadas permiten
    // una inserción y eliminación eficiente de elementos, ya que no requieren
    // mover otros elementos en la memoria. Sin embargo, el acceso a elementos
    // específicos puede ser más lento, ya que se debe recorrer la lista desde el
    // principio hasta el nodo deseado.

    public static void main(String[] args) {
        // Crear una LinkedList
        LinkedList<String> linkedList = new LinkedList<>();

        // Añadir elementos
        for (int i = 1; i <= 5; i++) {
            linkedList.add("Elemento " + i);
        }

        // Mostrar la lista
        System.out.println("LinkedList: " + linkedList.getClass().getSimpleName());
        System.out.println("Size: " + linkedList.size());
        System.out.println("Elements: " + linkedList);

        // Acceso a elementos cualquier List
        System.out.println("Primer elemento: " + linkedList.getFirst()); // Acceso al primer elemento
        System.out.println("Último elemento: " + linkedList.getLast()); // Acceso al último elemento
        System.out.println("Elemento en el índice 2: " + linkedList.get(2)); // Acceso al tercer elemento

        // Solo en linkedList
        System.out.println("Primer elemento (peek): " + linkedList.peek()); // Acceso al primer elemento

        // Extraer elementos (solo en LinkedList)
        System.out.println("Primer elemento (pop): " + linkedList.pop()); // Acceso al tercer elemento
        System.out.println("Después de pop: " + linkedList);
        System.out.println("Primer elemento (poll): " + linkedList.poll()); // Acceso al último elemento
        System.out.println("Después de poll: " + linkedList);

        System.out.println("Último elemento (pollLast): " + linkedList.pollLast()); // Acceso al último elemento
        System.out.println("Después de pollLast: " + linkedList);

        // Añadir elementos al principio y al final (cualquier lista)

        linkedList.addFirst("Primer Elemento"); // Añadir un elemento al principio
        linkedList.addLast("Último Elemento"); // Añadir un elemento al final

        // Solo para LinkedList

        linkedList.push("Pushed Element"); // Añadir un elemento al principio (similar a addFirst)
        linkedList.offerFirst("Offered First Element"); // Añadir un elemento al principio (similar a addFirst)
        linkedList.offer("Offered Last Element"); // Añadir un elemento al final (similar a addLast)

        System.out.println("Después de añadir Elementos: " + linkedList);
    }

}
