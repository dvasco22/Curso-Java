
import java.math.BigInteger;
import java.text.DecimalFormat;

public class FactBigInteger {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat(
                "###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###");

        int n = 40; // Cambia este número para otro factorial

        BigInteger factorial = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println(n + "! = " + df.format(factorial));
    }

}