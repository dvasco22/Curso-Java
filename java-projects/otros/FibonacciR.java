import java.util.Scanner;

public class FibonacciR {


    public static void main( String[] args ) {
      Scanner input = new Scanner(System.in);
      System.out.printf("Número de Términos : ");
      int n=input.nextInt();
    
      System.out.printf("%n%n");

      for (int i=1; i<n; i++)
          System.out.printf("%d,",FIB(i));

      System.out.printf("%d%n%n",FIB(n)
);

    }
 
    public static int FIB(int n) {
        if ((n==1) || (n==2)) {
           return 1;
        }else{ 
           return FIB(n-1) + FIB(n-2);
        }
    }

}