
package local.collections.exercises;

import java.util.List;
import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;

public class Ex01OOP {
    private List<String> listDays = new ArrayList<>();
    private List<String> listSecond = new ArrayList<>();

    private void populateList(List<String> list) {
        list.add("Lunes");
        list.add("Martes");
        list.add("Miércoles");
        list.add("Jueves");
        list.add("Viernes");
        list.add("Sábado");
        list.add("Domingo");
    }

    private void insertForth(String element) {
        final int POSITION = 4;
        if (listDays.size() >= POSITION) {
            listDays.add(POSITION, element);
        } else {
            System.out.println("La lista no tiene suficientes elementos para insertar en la posición " + POSITION);
        }
    }

    private void populateSecondList(List<String> list) {
        listSecond.addAll(list);
    }

    private void mergeLists(List<String> target, List<String> source) {
        target.addAll(source);
    }

    private void removeElement(String element) {
        boolean removed = true;
        do {
            removed = listDays.remove(element);
            if (removed) {
                System.out.println("Elemento '%s' eliminado.".formatted(element));
            } else {
                System.out.println("Elemento '%s' no encontrado.".formatted(element));
            }
        } while (removed);
    }

    private void sortList() {
        Collections.sort(listDays);
    }

    private void clearLists() {
        listDays.clear();
        listSecond.clear();
    }

    private void showList() {
        System.out.println("Contenido de la lista:");
        for (String day : listDays) {
            System.out.println(day);
        }
    }

    // private void showSecondList() {
    // System.out.println("Contenido de la listaDos:");
    // for (String day : listSecond) {
    // System.out.println(day);
    // }
    // }

    private void showListInLine() {
        System.out.println("Contenido de la lista:");
        System.out.println(listDays);
    }

    private void showPosition(int position) {
        if (position >= 0 && position < listDays.size()) {
            System.out.println("Elemento en la posición " + position + ": " + listDays.get(position));
        } else {
            System.out.println("Posición fuera de rango.");
        }
    }

    private void showByIterator() {
        System.out.println("Contenido de la lista usando iterador:");
        Iterator<String> it = listDays.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private void showFindElement(String element) {
        if (listDays.contains(element)) {
            System.out.println("El elemento '%s' existe en la lista.".formatted(element));
        } else {
            System.out.println("El elemento '%s' no existe en la lista.".formatted(element));
        }
    }

    private void showFindElementIgnoreCase(String element) {
        // boolean found = false;
        // for (String day : listDays) {
        // if (day.equalsIgnoreCase(element)) {
        // System.out.println("El elemento '%s' existe en la
        // lista.".formatted(element));
        // found = true;
        // break;
        // }
        // }
        // if (!found) {
        // System.out.println("El elemento '%s' no existe en la
        // lista.".formatted(element));
        // }

        Iterator<String> it2 = listDays.iterator();
        while (it2.hasNext()) {
            String currentElement = it2.next().toUpperCase();
            if (currentElement.equals(element.toUpperCase())) {
                System.out.println("Si existe " + currentElement);
                return;
            }
        }
        System.out.println("El elemento '%s' no existe en la lista.".formatted(element));
    }

    public void solveWeekExercise() {

        System.out.println("Crea una lista que contenga los días de la semana");
        populateList(listDays);
        System.out.println("Inserta en la posición 4 el elemento «Juernes»");
        insertForth("Juernes");
        showList();
        System.out.println("-----------------------------------------------");
        System.out.println("Copia esa lista a otra llamada listaDos");
        populateSecondList(listDays);
        System.out.println("Añade a listDias el contenido de listaDos");
        mergeLists(listDays, listSecond);
        showList();
        System.out.println("-----------------------------------------------");
        System.out.println("Muestra el contenido de las posiciones 3 y 4 de la lista original");
        showPosition(3);
        showPosition(4);
        System.out.println("Muestra el primer elemento y el último de la lista original");
        showPosition(0);
        showPosition(listDays.size() - 1);
        System.out.println("-----------------------------------------------");
        System.out.println("Elimina el elemento que contenga «Juernes» de la lista y comprueba si elimina algo o no.");
        showListInLine();
        removeElement("Juernes");
        showListInLine();
        System.out.println("-----------------------------------------------");
        System.out.println("Crea un iterador y muestra uno a uno los valores de la lista original");
        showByIterator();
        System.out.println("-----------------------------------------------");
        System.out.println("Busca si existe en la lista un elemento que se denomine «Lunes».");
        showFindElement("Lunes");
        System.out.println(
                "Busca si existe en la lista un elemento que se denomine «Lunes». No importa si está en mayúscula o minúscula.");
        showFindElementIgnoreCase("LUNES");
        showFindElementIgnoreCase("JuEVeS");
        System.out.println("-----------------------------------------------");
        System.out.println("Ordena la lista y muestra su contenido");
        sortList();
        showListInLine();
        System.out.println("-----------------------------------------------");
        System.out.println("Borra todos los elementos de la lista.");
        clearLists();
        showListInLine();
    }

    public static void main(String[] args) {

        Ex01OOP ex = new Ex01OOP();
        ex.solveWeekExercise();
    }
}