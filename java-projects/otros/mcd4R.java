import java.util.Scanner;

public class mcd4R {

    public static void main( String[] args ) {

      Scanner input = new Scanner(System.in);

      int a,b,c,d;

      System.out.printf("MCD(a,b,c,d)%n%n");
      System.out.printf("a : ");
      a = input.nextInt();
      System.out.printf("b : ");
      b = input.nextInt();
      System.out.printf("c : ");
      c = input.nextInt();
      System.out.printf("d : ");
      d = input.nextInt();

      System.out.printf("%n%nMCD(%d,%d,%d)=%d%n",a,b,c,MCD(a,MCD(b,MCD(c,d))));

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