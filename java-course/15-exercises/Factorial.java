import java.text.DecimalFormat;

public class Factorial {

    static double FACT(int x) {
        if (x < 0) {
            x = x * -1; // |x|
        }

        double fact = 1; // 0! = 1

        for (int i = x; i > 0; i--) {
            fact = fact * i; // result *= i;
        }
        return fact;
    }

    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat(
                "###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###");

        int x = 30;
        System.out.printf("%-35s", df.format(FACT(x)));

    }

}