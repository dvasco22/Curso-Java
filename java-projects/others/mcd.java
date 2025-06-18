import java.util.Scanner;

public class mcd {

    public static void main( String[] args ) {

      Scanner input = new Scanner(System.in);

      int r, mayor, menor, n, m;
      
      System.out.printf("Numero Mayor : ");
      mayor=input.nextInt();
      n=mayor;

      System.out.printf("Numero Menor : ");
      menor=input.nextInt();
      m=menor;

      r = mayor % menor;

      while (r != 0) {
            mayor = menor;
            menor = r;
            r = mayor % menor;

           System.out.printf("r:%d  menor:%d  mayor:%d%n ",r,menor,mayor);
        } 


      System.out.printf("%n%n%n MCD(%d,%d)=%d%n",m,n,menor);


    }


}