
package local.concept1;

import java.util.Scanner;

import local.exceptions.BusinessException;
import local.exceptions.ErrorCodes;

public class Calculator {

    private int num1;
    private int num2;

    public void setNum1(String message) {
        this.num1 = getInteger(message);
    }

    public void setNum2(String message) {
        this.num2 = getInteger(message);
    }

    int add() {
        int result = num1 + num2;
        return result;
    }

    int subtract() {
        int result = num1 - num2;
        return result;
    }

    int multiply() {
        int result = num1 * num2;
        return result;
    }

    int intDivide() throws BusinessException {
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

    int restDivision() {
        int result = num1 % num2;
        return result;
    }

    void showResult(String operation, int result) {
        System.out.printf("El resultado de la %s es %s", operation, result);
        System.out.println("");
    }

    void showAllResults() throws BusinessException {
        System.out.printf("Operaciones con %s y %s\n", num1, num2);
        showResult("suma", add());
        showResult("resta", subtract());
        showResult("producto", multiply());
        showResult("división", intDivide());
        showResult("resto", restDivision());
    }

    private int getInteger(String message) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        int num = scanner.nextInt();

        return num;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        // Bucle while para repetir con distintos pares de números
        calc.setNum1("Dime un número entero");
        calc.setNum2("Dime otro número entero");

        try {
            calc.showAllResults();
        } catch (BusinessException e) {
            System.err.println(e.getMessage());
            System.err.println(e.getCause());
        }
    }

}