
/*package local.concept1;

import java.text.NumberFormat;
import java.util.Locale;

import local.exceptions.BusinessException;
import local.exceptions.ErrorCodes;
import local.exceptions.TechnicalException;

public class Factorial {

    static void showNumber(long number) {
        NumberFormat nf = NumberFormat.getInstance(Locale.GERMANY);
        System.out.println(nf.format(number));
    }

    short number;

    Factorial() {
    }

    Factorial(short number) {
        this.number = number;
    }

    long calculateFactorial() throws BusinessException {
        return calculateFactorial(number);
    }

    long calculateFactorial(short number) throws BusinessException {
        if (number < 0) {
            String message = "No se puede calcular el factorial de " + number;
            // throw new TechnicalException(message);
            throw new BusinessException(ErrorCodes.ERROR_NEGATIVE, message);
        }

        if (number > 10) {
            String message = "No se puede calcular el factorial de " + number;
            // throw new TechnicalException(message);
            throw new BusinessException(ErrorCodes.ERROR_BIGGER_20, message);
        }

        long result = 1;

        for (short i = number; i > 0; i--) {
            result = result * i;
            // result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        short num = 10;
        num = 0;
        num = 1;
        num = -5;
        num = 21;
        num = 20;
        try {
            long result = factorial.calculateFactorial(num);
            showNumber(result);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Fin del programa");

    }

}*/

package local.concept1;

import java.text.NumberFormat;
import java.util.Locale;

import local.exceptions.BusinessException;
import local.exceptions.ErrorCodes;

public class Factorial {

    static void showNumber(long number) {
        NumberFormat nf = NumberFormat.getInstance(Locale.GERMANY);
        System.out.println(nf.format(number));
    }

    short number;

    Factorial() {
    }

    Factorial(short number) {
        this.number = number;
    }

    long calculateFactorial() throws BusinessException {
        return calculateFactorial(number);
    }

    long calculateFactorial(short number) throws BusinessException {
        if (number < 0) {
            String message = "No se puede calcular el factorial de " + number;
            // throw new TechnicalException(message);
            throw new BusinessException(ErrorCodes.ERROR_NEGATIVE, message);
        }

        if (number > 10) {
            String message = "No se puede calcular el factorial de " + number;
            // throw new TechnicalException(message);
            throw new BusinessException(ErrorCodes.ERROR_BIGGER_20, message);
        }

        long result = 1;

        for (short i = number; i > 0; i--) {
            result = result * i;
            // result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        short num = 10;
        num = 0;
        num = 1;
        num = -5;
        num = 21;
        num = 20;
        try {
            long result = factorial.calculateFactorial(num);
            showNumber(result);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Fin del programa");

    }

}