import java.util.Scanner;

public class suma {

    public static void main( String[] args ) {

      Scanner input = new Scanner(System.in);

      int suma=0;
      int cont=0; 
     
      System.out.printf("Entre n : ");
      int n=input.nextInt();


      while (cont <n) {
            cont++;
            suma=suma+cont;
      }
      System.out.printf("la suma de los primeros %d números es %d ",n,suma);

    }
}