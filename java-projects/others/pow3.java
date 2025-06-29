import java.util.Scanner;

public class pow3 {

    public static void main( String[] args ) {

      Scanner input = new Scanner(System.in);

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
            
      for(int i=0;i<n;i++)
           pow=pow*b;
      
      System.out.printf("%d a la %d es igual %d",b,n,pow);

    }
}