import java.util.Scanner;

public class pow4 {

    public static void main( String[] args ) {

      Scanner input = new Scanner(System.in);

      int pow=1, cont=0,base  =0;
      boolean leave =true;
     
      do {

        System.out.printf("Base : ");
        base=input.nextInt();
        if (base==0) 
           System.out.printf("Base debe ser diferente de 0 \n");
        else
           leave=false;

      } while(leave);


      System.out.printf("Exponente : ");
      int exp=input.nextInt();


      while (cont<exp) {
            cont++;
            pow=pow*base;
      }
      
      System.out.printf("\n %d Elevado a la  %d es igual a %d \n",base,exp,pow);

    }
}