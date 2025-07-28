package local.concept2_vc;

import local.exceptions.BusinessException;
import local.exceptions.ErrorCodes;

public class CalcController extends Calc {

    private int num1;
    private int num2;

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int add() {
        int result = num1 + num2;
        return result;
    }

    public int subtract() {
        int result = num1 - num2;
        return result;
    }

    public int multiply() {
        int result = num1 * num2;
        return result;
    }

    public int intDivide() throws BusinessException {
        try {
            int result = num1 / num2;
            return result;

        } catch (ArithmeticException e) {
            throw new BusinessException(
                    ErrorCodes.ERROR_ZERO,
                    "Dividiendo por 0",
                    e);
        }
    }

    public double decimalDivide() {
        double result = (double) num1 / num2;
        return result;
    }

    public double decimalDivideNoNan() throws BusinessException {
        if (num2 == 0) {
            throw new BusinessException(
                    ErrorCodes.ERROR_ZERO,
                    "Dividiendo por 0");
        }

        double result = (double) num1 / num2;
        return result;
    }

    public int restDivision() {
        int result = num1 % num2;
        return result;
    }

    public long calculateFactorial() throws BusinessException {
        return calculateFactorial((short) num1);
    }

    public long calculateFactorial(byte i) throws BusinessException {
        if (i == 1) {
            return calculateFactorial((short) num1);
        }
        return calculateFactorial((short) num2);
    }

    public long calculateFactorial(short number) throws BusinessException {

        final int MAX_SAFE_FACTORIAL_VALUE = 20;

        if (number < 0) {
            String message = "No se puede calcular el factorial de " + number;
            // throw new TechnicalException(message);
            throw new BusinessException(ErrorCodes.ERROR_NEGATIVE, message);
        }

        if (number > MAX_SAFE_FACTORIAL_VALUE) {
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

    public int pow() throws BusinessException {
        return pow(num1, num2);
    }

    public int pow(int num1, int num2) throws BusinessException {

            if (num2 < 0) {
            String message = "No se pueden calcular potencias de " + num2;
            // throw new TechnicalException(message);
            throw new BusinessException(ErrorCodes.ERROR_NEGATIVE, message);
        }

        int result = 1;
        for (int i = 1; i <= num2; i++) {
            result *= num1;
        }
        return result;
    }

   
}
