
import java.util.Scanner;

public class Calculator {
    // Función: código ejecutable
    // Puedo invocarlo por su nombre
    // Puede recibir valores -> los recoge como parámetros
    // Puede devolver un valor

    static int add(int num1, int num2) {
        int result = num1 + num2;
        return result;
    }

    static int subtract(int num1, int num2) {
        int result = num1 - num2;
        return result;
    }

    static int multiply(int num1, int num2) {
        int result = num1 * num2;
        return result;
    }

    static int intDivide(int num1, int num2) {
        int result = num1 / num2;
        return result;
    }

    static int restDivision(int num1, int num2) {
        int result = num1 % num2;
        return result;
    }

    static void showResult(String operation, int result) {
        System.out.printf("El resultado de la %s es %s", operation, result);
        System.out.println("");
    }

    static int getInteger(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        int num = scanner.nextInt();
        // scanner.close();
        return num;
    }

    public static void main(String[] args) {
        int num1 = getInteger("Dime un número entero");
        int num2 = getInteger("Dime otro número entero");
        // Los argumentos son los valores que llegarán a los parámetros
        System.out.printf("Operaciones con %s y %s\n", num1, num2);
        showResult("suma", add(num1, num2));
        showResult("resta", subtract(num1, num2));
        showResult("producto", multiply(num1, num2));
        showResult("división", intDivide(num1, num2));
        showResult("resto", restDivision(num1, num2));
    }

}
