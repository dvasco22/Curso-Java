import java.util.Scanner;

public class mcd2R {

    public static void main( String[] args ) {

      Scanner input = new Scanner(System.in);

      int a,b;

      boolean salir=true;

      do {
         System.out.printf("Primer n�mero : ");
         a = input.nextInt();
         if (a > 0)
            salir = false;
         else 
            System.out.printf("N�mero debe ser > 0 !! %n");
          
      } while(salir);


      salir=true;

      do {
         System.out.printf("Segundo n�mero : ");
         b = input.nextInt();
         if ((b > 0) && (a>=b))
            salir = false;
         else  
            if (a<b)
               System.out.printf("El segundo n�mero debe ser MENOR/IGUAL que el primer n�mero!! %n");
            else
               System.out.printf("N�mero debe ser > 0 !! %n");
      } while(salir);



      System.out.printf("MCD(%d,%d)=%d%n",a,b,MCD(a,b));

    }

    public static int MCD(int a, int b) {
        int mcd;

        if (b==0)
           mcd=a;
        else 
           mcd=MCD(b,a%b);     

        return mcd;
    }
}