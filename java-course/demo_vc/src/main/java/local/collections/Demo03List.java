package local.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo03List {

    // Uso de Arrays.asList
    public void createListFromArray1() {

        Integer[] array = { 1, 2, 3, 4, 5 };
        System.out.println("Array al principio " + Arrays.toString(array));

        // Crear una lista a partir de un array
        // Puedes usar el método Arrays.asList(array) para crear una lista a partir de
        // un array.
        // Este método devuelve una lista fija, por lo que no puedes añadir o eliminar
        // elementos.
        List<Integer> listFromArray1 = Arrays.asList(array);
        // Para evitar modificar el array podemos clonarlo
        // List<Integer> listFromArray1 = Arrays.asList(array.clone());
        // Esta lista es inmutable, no puedes añadir o eliminar elementos.
        // ---> listFromArray1.add(66); // Esto lanzará UnsupportedOperationException
        // porque
        // la lista es fija.
        listFromArray1.set(0, 100); // Puedes modificar elementos existentes

        // Mostrar las listas creadas
        System.out.println("List1 created from array: " + listFromArray1);

        // Mostrar el array
        System.out.println("Array al final " + Arrays.toString(array));
    }

    // List.of
    public void createListFromArray2() {

        Integer[] array = { 1, 2, 3, 4, 5 };
        System.out.println("Array al principio " + Arrays.toString(array));

        // Si necesitas una lista dinámica, puedes crear un ArrayList a partir de la
        // lista fija.
        // Puedes usar List.of(array) para crear una lista mutable a partir de un array
        List<Integer> listFromArray2 = new ArrayList<>(List.of(array));
        // Esta lista es dinámica, puedes añadir o eliminar elementos.
        listFromArray2.add(6); // Ahora puedes añadir elementos
        listFromArray2.remove(0); // También puedes eliminar elementos
        listFromArray2.set(1, 300); // Puedes modificar elementos existentes
        // listFromArray2.sort((a,b) -> a - b); // Ordenar la lista en orden
        // ascendente);
        listFromArray2.sort(Comparator.naturalOrder()); // Ordenar la lista en orden ascendente

        // Mostrar las listas creadas
        System.out.println("List2 created from array: " + listFromArray2);

        while (!listFromArray2.isEmpty()) {
            // Eliminar el último elemento de la lista
            Integer lastElement = listFromArray2.remove(listFromArray2.size() - 1);
            System.out.println("Removed last element: " + lastElement);

        }
        System.out.println("List2 created from array: " + listFromArray2);

        // Mostrar el array
        System.out.println("Array al final " + Arrays.toString(array));
    }

    public static void main(String[] args) {
        Demo03List demo = new Demo03List();

        demo.createListFromArray1();
        System.out.println("-----------------------------------------");
        demo.createListFromArray2();
    }

}