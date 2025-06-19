import java.util.Scanner;

public class mcdEuclides2 {

    public static void main( String[] args ) {

      Scanner input = new Scanner(System.in);

      int a,b,c,d;
      
      System.out.printf(" a : ");
      a=input.nextInt();

      System.out.printf(" b : ");
      b=input.nextInt();

      System.out.printf(" c : ");
      c=input.nextInt();

      System.out.printf(" d : ");
      d=input.nextInt();

      System.out.printf("%n%n MCD(%d,%d,%d,%d)=%d%n%n",a,b,c,d,MCD(a,MCD(b,MCD(c,d))));
    }


    public static int MCD(int a, int b) {
      while (b > 0) 
         if (a > b)
            a = a - b;  
         else
            b = b - a;

      return a;
    }

}