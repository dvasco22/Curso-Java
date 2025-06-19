import java.util.Scanner;

public class mcdR {

    public static void main( String[] args ) {

      Scanner input = new Scanner(System.in);

      int m,n;

      boolean salir=true;

      do {
         System.out.printf("Primer n�mero : ");
         n = input.nextInt();
         if (n > 0)
            salir = false;
         else 
            System.out.printf("N�mero debe ser > 0 !! %n");
          
      } while(salir);


      salir=true;

      do {
         System.out.printf("Segundo n�mero : ");
         m = input.nextInt();
         if (m > 0)
            salir = false;
         else 
            System.out.printf("N�mero debe ser > 0 !! %n");
          
      } while(salir);



      System.out.printf("MCD(%d,%d)=%d%n",n,m,MCD(n,m));

    }

    public static int MCD(int n, int m) {
        int mcd;

        if (n==m)
           mcd=n;
        else 
           if (n>m)
              mcd=MCD(n-m,m);
           else
              mcd=MCD(m-n,n);

       return mcd;
    }
}