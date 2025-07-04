import java.math.BigInteger;  //maneja grandes numeros
import java.text.DecimalFormat;


public class FactBigInteger {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat(
                "###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###");

        int n = 100000; // Cambia este número para otro factorial

        BigInteger factorial = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println(n + "! = " + df.format(factorial));
    }

}


/*
 * resultado = math.factorial(100)
resultado_str = f"{resultado:,}".replace(",", " ")
print(resultado_str)
 */

/*
 import math

resultado = math.factorial(100)
print(f"{resultado:.5e}")  # 5 dígitos significativos en notación científica
 */