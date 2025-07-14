package local.collections.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Ex01 {
    List<String> listDays = new ArrayList<>();

    public void createWeek() {

        // Crea una lista que contenga los días de la semana.
        listDays.add("Lunes");
        listDays.add("Martes");
        listDays.add("Miércoles");
        listDays.add("Jueves");
        listDays.add("Viernes");
        listDays.add("Sábado");
        listDays.add("Domingo");

        // Inserta en la posición 4 el elemento «Juernes».
        listDays.add(4, "Juernes");
        // listDias.set(4, "Juernes");

        // Copia esa lista a otra llamada listaDos.
        ArrayList<String> listSecond = new ArrayList<>();
        listSecond.addAll(listDays);

        // Añade a listDias el contenido de listaDos.
        listDays.addAll(listSecond);

        // Muestra el contenido de las posiciones 3 y 4 de la lista original.
        System.out.println(listDays.get(3));
        System.out.println(listDays.get(4));

        // Muestra el primer elemento y el último de la lista original.
        System.out.println(listDays.get(0));
        System.out.println(listDays.get(listDays.size() - 1));

        // Elimina el elemento que contenga «Juernes» de la lista y comprueba si elimina
        // algo o no.
        System.out.println(listDays);
        boolean removed = true;
        do {
            removed = listDays.remove("Juernes");
            if (removed) {
                System.out.println("Elemento 'Juernes' eliminado.");
            } else {
                System.out.println("Elemento 'Juernes' no encontrado.");
            }
        } while (removed);
        System.out.println(listDays);

        // Crea un iterador y muestra uno a uno los valores de la lista original.

        System.out.println("Iterando sobre la lista de días:");
        Iterator<String> it = listDays.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // listDays.forEach(item -> System.out.println(item));

        // Busca si existe en la lista un elemento que se denomine «Lunes».

        if (listDays.contains("Lunes")) {
            System.out.println("Si existe Lunes");
            System.out.println("------------------------------");
        }

        // Busca si existe en la lista un elemento que se denomine «Lunes». No importa
        // si está en mayúscula o minúscula.

        Iterator<String> it2 = listDays.iterator();
        while (it2.hasNext()) {
            String item = it2.next();
            // if (item.toUpperCase().equals("LUNES")) {
            if (item.equalsIgnoreCase("LUNES")) {
                System.out.println("Si existe " + item);
            } else {
                System.out.println("No existe Lunes");
            }
        }

        // Ordena la lista y muestra su contenido.
        Collections.sort(listDays, Comparator.reverseOrder());
        // listDays.sort( Comparator.reverseOrder());
        System.out.println(listDays);

        // Borra todos los elementos de la lista.
        listDays.clear();
        System.out.println(listDays);
    }

    public static void main(String[] args) {

        Ex01 exercise = new Ex01();
        exercise.createWeek();
    }
}
