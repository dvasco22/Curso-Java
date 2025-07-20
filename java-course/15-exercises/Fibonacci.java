
import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("¿Por debajo de que numero deseas ver la serie? : ");
        int n = input.nextInt();

        FIB(n);
        System.out.printf("%n%n");
        // System.out.printf("Ultimo termino :: %d%n%n", NFIB(n));
        input.close();

    }

    public static void FIB(int lastTerm) {
        int fib, f1 = 1, f2 = 1, cont = 3;

        System.out.printf("0,1,1");
        boolean leave = false;

        while (!leave) {
            fib = f1 + f2;
            f1 = f2;
            f2 = fib;

            if (fib > lastTerm) {
                leave = true;
                System.out.printf(" [ %d Términos antes de %d ]", cont, lastTerm);
            } else {
                System.out.printf(",%d", fib);
                cont++;
            }
        }
    }

    public static int NFIB(int n) {
        int fib = 0, f1 = 1, f2 = 1, cont = 2;

        while (cont < n) {
            fib = f1 + f2;
            f1 = f2;
            f2 = fib;
            cont++;
        }
        return fib;
    }

}