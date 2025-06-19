import java.util.Scanner;

public class mcd {
    
     /*

         Máximo Común Dividor (MCD) Es el MAYOR número po el cual se pueden dividir 2 ó más enteros 
         sin dejar residuo
         
         MCD(a,b)= Factor común con el menor exponente

      */

    public static void main( String[] args ) {

      Scanner input = new Scanner(System.in);

      int r, mayor, menor, ma, me;
      
      System.out.printf("Numero Mayor : ");
      mayor=input.nextInt();
      ma=mayor;

      System.out.printf("Numero Menor : ");
      menor=input.nextInt();
      me=menor;

      r = mayor % menor;

      while (r != 0) {
            mayor = menor;
            menor = r;
            r = mayor % menor;

           //System.out.printf("r:%d  menor:%d  mayor:%d%n ",r,menor,mayor);
        } 

      System.out.printf("%n%n%n MCD(%d,%d)=%d%n",ma,me,mayor);

    }

}