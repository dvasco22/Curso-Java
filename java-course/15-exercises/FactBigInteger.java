
/* Entrar un numero ya sea por parámetro o por teclado para calcular el factorial */

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Scanner;

public class FactBigInteger {

    static int getNbyKeboard() {

        Scanner keyBoard = new Scanner(System.in);
        System.out.print("Dame un numero entero : ");
        int age = keyBoard.nextInt();
        keyBoard.close();
        return age;
    }

    static int getN(String[] args) {

        int n;

        if (args.length == 0)
            n = getNbyKeboard(); // input age by keyboard if there isn`t any value from command line
        else
            n = Integer.valueOf(args[0]); // take age from command line

        return n;
    }

    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat(
                "###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###");

        // int n = 40; // Cambia este número para otro factorial
        int n = Math.abs(getN(args)); // |n-10|
        BigInteger factorial = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println(n + "! = " + df.format(factorial));
    }

}