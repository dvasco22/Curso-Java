import java.util.Scanner;

public class mcdEuclides {

    public static void main( String[] args ) {

      Scanner input = new Scanner(System.in);

      int a, b;
      
      System.out.printf("a : ");
      a=input.nextInt();

      System.out.printf("b : ");
      b=input.nextInt();

      System.out.printf("%n%n%n MCD(%d,%d)=",a,b);

      while (b > 0) 
            if (a > b)
               a = a - b;
            else
               b = b - a;

      System.out.printf("%d%n%n",a);
    }

}