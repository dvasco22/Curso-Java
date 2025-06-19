import java.util.Scanner;

public class mcd3R {

    public static void main( String[] args ) {

      Scanner input = new Scanner(System.in);

      int a,b;
      System.out.printf("MCD(a,b)%n%n");
      System.out.printf("a : ");
      a = input.nextInt();
      System.out.printf("b : ");
      b = input.nextInt();

      System.out.printf("MCD(%d,%d)=%d%n",a,b,MCD(a,b));

    }

    public static int MCD(int a, int b) {
        int mcd;

      if(a >= 0) 
      {
        if (b == 0)
           mcd = a;
        else 
           mcd = MCD(b,a%b);     
      }
      else
      {
        if (a == 0)
           mcd = b;
        else 
           mcd = MCD(a,b%a);     
      }

      return mcd;

    }
}