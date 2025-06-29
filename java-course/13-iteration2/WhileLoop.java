import java.util.Random;

public class WhileLoop {

    static void whileSample() {
        boolean flag = true;

        while (flag) {
            Random randomCreator = new Random();
            int number = randomCreator.nextInt(9) + 1; // genera enteros de 0 a 9

            if (number % 2 == 0) {
                continue;
            }

            System.out.println("Número " + number);
            if (number == 7) {
                flag = false;
            }
        }
    }

    static void forSample() {

        for (int i = 0; i >= 0; i++) {
            Random randomize = new Random(); // Instancia objeto random randomize
            int number = randomize.nextInt(9) + 1; // crea entero number de 0 a 10

            if (number % 2 == 0) {
                continue; // excluye números pares
            }

            System.out.println("Número " + number);
            if (number == 9) {
                break; // termina el for cuando el número sea 9
            }
        }

    }

    static void forSample2() {

        int number = 0;

        for (int i = 0; number != 7; i++) {
            Random randomCreator = new Random();
            number = randomCreator.nextInt(9);

            if (number % 2 == 0) {
                continue;
            }

            System.out.printf("Número %s = %s\n", i + 1, number);
        }
    }

    static void whileSampleWithCounter() {
        boolean flag = true;
        int i = 0;

        while (flag) {
            i++;
            Random randomCreator = new Random();
            int number = randomCreator.nextInt(9);

            if (number % 2 == 0) {
                continue;
            }

            System.out.printf("Número %s = %s\n", i, number);
            if (number == 7) {
                flag = false;
            }
        }
    }

    public static void main(String[] args) {
        // whileSample();
        // forSample();
        // forSample2();
        whileSampleWithCounter();

    }

}
