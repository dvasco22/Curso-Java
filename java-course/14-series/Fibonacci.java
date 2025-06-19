import java.util.Scanner;

public class Fibonacci {

    public static void showSeries(int lastTerm) {
       int fib = 0;
       int f1  = 1;
       int f2  = 1;
       boolean leave=false;

       System.out.printf("0,1,1");

       while (!leave) {
           fib = f1+f2;
           f1=f2;
           f2=fib;

           //System.out.printf(",%d",fib);

           if (fib >= lastTerm) 
              leave= true;
           else
              System.out.printf(",%d",fib);
           
       } //while
    }//showSeries
  
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.printf("De el último Término : ");
      int n=input.nextInt();
      input.close();
      showSeries(n);
      
    } //main
}//class