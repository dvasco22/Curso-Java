import java.util.Scanner;

public class potencia {

    public static void main( String[] args ) {

      Scanner input = new Scanner(System.in);

      int cont=0;
      int pow=1;
      int b;
      int n;
      boolean salir=true;      
      
      do {
         System.out.printf("Base  : ");
         b=input.nextInt();
         if (b!=0)
            salir=false;

      } while(salir);
        
      System.out.printf("exponente  : ");
      n=input.nextInt();
            

      while(cont<n){
           cont++;
           pow=pow*b;
      }
      
      System.out.printf("%d a la %d es igual %d",b,n,pow);

    }
}