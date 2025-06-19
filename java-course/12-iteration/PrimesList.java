
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimesList {

    private static int getDataByScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dime un número para obtener todos los primos menores que el");
        int number = scanner.nextInt();
        System.out.println("");
        scanner.close();
        return number;
    }

    private static void showPrimes(int number) {
        for (int i = 1; i < number; i++) {
            if (Primes.isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private static List<Integer> calculatePrimes(int number) {
        //List<Integer> result = new ArrayList<Integer>();
        //ArrayList<Integer> result = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < number; i++) {
            if (Primes.isPrime(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int number = getDataByScanner();
        // showPrimes(number);
        List<Integer> numbers = calculatePrimes(number);
        for (int prime : numbers) {
            System.out.println(prime);
        }
    }

}
