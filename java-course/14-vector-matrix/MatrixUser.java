
// Le pedimos al usuario 9 animales y los guardamos como matriz de 3x3
// Le presentamos los nombres que nos ha dado.  

// 1. Pedir los datos
// 2. Presentar datos

import java.util.Random;
import java.util.Scanner;

public class MatrixUser {

    static String[][] getData() {
        String[][] animals = new String[3][3];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < animals.length; i++) {
            System.out.printf("Fila número %s\n", i + 1);
            for (int j = 0; j < animals[0].length; j++) {
                System.out.printf("Dime el animal %s\n", j + 1);
                animals[i][j] = scanner.nextLine();
            }
            System.out.println("Vamos a la siguiente fila");
        }
        // scanner.close();
        return animals;
    }

    static String[][] getAnimals() {
        String[][] animals = new String[3][3];

        String[] messages = {
                "Dime tres animales domésticos\n",
                "Dime tres animales salvajes\n",
                "Dime tres animales no mamíferos\n"
        };

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < animals.length; i++) {
            System.out.printf(messages[i]);
            for (int j = 0; j < animals[0].length; j++) {

                System.out.printf("Dime el animal %s\n", j + 1);
                animals[i][j] = scanner.nextLine();
            }

            if (i < animals.length - 1) {
                System.out.println("Vamos a la siguiente fila");
            } else {
                System.out.println("Gracias por participar");
            }
        }
        // scanner.close();
        return animals;
    }

    static String[] selectRandoms(String[][] data) {
        String[] selectedAnimals = new String[data.length];
        Random r = new Random();
        for (int i = 0; i < selectedAnimals.length; i++) {
            selectedAnimals[i] = data[i][r.nextInt(2)];
        }
        return selectedAnimals;

    }

    static void showData(String[][] data) {

        System.out.println("------------------");
        System.out.println("Aquí tienes tus animales");

        for (String[] row : data) {
            for (String item : row) {
                System.out.printf("%-15s ", item);
            }
            System.out.println("");
        }
    }

    static void showData(String[] data) {
        System.out.println("------------------");
        System.out.println("Aquí tienes tus animales en esta tirada");

        for (String item : data) {
            System.out.printf("%-15s ", item);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        // showData(getData());
        String[][] animals = getAnimals();
        showData(animals);

        Scanner scanner = new Scanner(System.in);
        boolean wantContinue = true;

        while (wantContinue) {

            String[] selectAnimals = selectRandoms(animals);
            showData(selectAnimals);

            System.out.println("¿Quieres continuar (S/N)?");
            String answer = scanner.nextLine();
            if (answer.toLowerCase().equals("n") ||
                    answer.toLowerCase().equals("no")) {
                wantContinue = false;
            }

        }

        scanner.close();
        System.out.println("Gracias por todo");

    }

}