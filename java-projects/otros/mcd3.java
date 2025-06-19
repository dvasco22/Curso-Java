import java.util.Scanner;

public class mcd3 {

    public static void main( String[] args ) {

      Scanner input = new Scanner(System.in);

      int mod, a, b, Ma, Me;
      
      System.out.printf("a : ");
      a=input.nextInt();

      System.out.printf("b : ");
      b=input.nextInt();


      if (a>=b) {
          Ma = a;
          Me = b;
      }else{
          Ma = b;
          Me = a;
      }

      mod = Ma % Me;

      while (mod != 0) {
            Ma = Me;
            Me = mod;
            mod = Ma % Me;

      } 

      System.out.printf("%n%n%n MCD(%d,%d)=%d%n",a,b,Me);

    }

}