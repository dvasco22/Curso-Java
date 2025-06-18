import java.util.Scanner;

public class FibonacciP {


    public static void main( String[] args ) {
      Scanner input = new Scanner(System.in);
      System.out.printf("Número de Términos : ");
      int n=input.nextInt();

      FIB(n);
      System.out.printf("%n%n");
      System.out.printf("Ultimo termino :: %d%n%n",NFIB(n));

    }
 
      
    public static void FIB(int n) {
      int fib, f1=1, f2=1, cont=2;

      System.out.printf("%n%nFIB(%d)=1,1",n);

      while (cont < n) {
            fib = f1 + f2;
            f1 = f2;
            f2 = fib;
            cont++;
            System.out.printf(",%d",fib);
      }
    }

    public static int NFIB(int n) {
      int fib=0, f1=1, f2=1, cont=2;

      while (cont < n) {
            fib = f1 + f2;
            f1 = f2;
            f2 = fib;
            cont++;
      }
      return fib;
    }

}