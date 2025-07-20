
/*package local.concept2_vc;

import java.util.Scanner;

import local.exceptions.BusinessException;

public class CalcView extends Calc {

    private int number1 = 20;
    private int number2 = 2;

    private CalcController ctr; // = new CalcController();

    CalcView(CalcController ctr) {
        this.ctr = ctr;
        this.ctr.setNum1(number1);
        this.ctr.setNum2(number2);
    }

    private int getInteger(String message) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        int num = scanner.nextInt();

        return num;
    }

    private void showMenu() {
        String menu = """

                Elige el número de la opción que quieras
                ----------------------------------------
                1. Dime un número (%s)
                2. Dime otro número (%s)
                3. Calcula la suma
                4. Calcula la resta
                5. Calcula la multiplicación
                6. Calcula la division y el resto
                7. Calcula la división con decimales
                8. Calcula todos los anteriores
                9. Calcula el factorial del primero
                0. Salir """.formatted(number1, number2);

        System.out.println(menu);
    }

    private void calculate(int option) throws BusinessException {
        System.out.println("Calculando la opción " + option);

        switch (option) {
            case 3:
                showResult("suma", ctr.add());
                break;
            case 4:
                showResult("resta", ctr.subtract());
                break;
            case 5:
                showResult("producto", ctr.multiply());
                break;
            case 6:
                showResult("división", ctr.intDivide());
                showResult("resto", ctr.restDivision());
                break;
            case 7:
                // No disponible
                break;
            case 8:
                showAllResults();
                break;
            case 9:
                showResult("factorial", ctr.calculateFactorial());
                break;
            default:
                break;
        }

    }

    void showResult(String operation, int result) {
        System.out.printf("El resultado de la %s es %s", operation, result);
        System.out.println("");
    }

    void showResult(String operation, long result) {
        System.out.printf("El factorial de %s es %s", operation, result);
        System.out.println("");
    }

    void showAllResults() throws BusinessException {
        System.out.printf("Operaciones con %s y %s\n", number1, number2);
        showResult("suma", ctr.add());
        showResult("resta", ctr.subtract());
        showResult("producto", ctr.multiply());
        showResult("división", ctr.intDivide());
        showResult("resto", ctr.restDivision());
    }

    void show() throws BusinessException {
        Scanner scanner = new Scanner(System.in);
        boolean wantContinue = true;

        while (wantContinue) {
            showMenu();
            int answer = scanner.nextInt();
            if (answer == 0) {
                wantContinue = false;
            } else if (answer == 1) {
                number1 = getInteger(" Dime el primer número");
                ctr.setNum1(number1);
            } else if (answer == 2) {
                number2 = getInteger(" Dime el segundo número");
                ctr.setNum2(number2);
            } else {
                calculate(answer);
            }
        }
        scanner.close();
        System.out.println("Gracias por todo");
    }
}*/

package local.concept2_vc;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import local.exceptions.BusinessException;

public class CalcView extends Calc {

    private int number1;
    private int number2;

    private CalcController ctr; // = new CalcController();

    CalcView(CalcController ctr) {
        this.ctr = ctr;
        this.ctr.setNum1(number1);
        this.ctr.setNum2(number2);
    }

    private int getInteger(String message) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        try {
            int num = scanner.nextInt();
            return num;
        } catch (InputMismatchException e) {
            System.out.println("Tipo de dato no válido");
            return 0;
        }

    }

    private void showMenu() {
        String menu = """

                Elige el número de la opción que quieras
                ----------------------------------------
                1. Dime un número entero (%s)
                2. Dime otro número entero (%s)
                3. Calcula la suma
                4. Calcula la resta
                5. Calcula la multiplicación
                6. Calcula la division y el resto
                7. Calcula la división con decimales
                8. Calcula todos los anteriores
                9. Calcula el factorial del primero
                0. Salir """.formatted(number1, number2);

        System.out.println(menu);
    }

    private void calculate(int option) throws BusinessException {

        switch (option) {
            case 3:
                showResult("suma", ctr.add());
                break;
            case 4:
                showResult("resta", ctr.subtract());
                break;
            case 5:
                showResult("producto", ctr.multiply());
                break;
            case 6:
                showResult("división", ctr.intDivide());
                showResult("resto", ctr.restDivision());
                break;
            case 7:
                showResult("división", ctr.decimalDivide());
                break;
            case 8:
                showAllResults();
                break;
            case 9:
                showResult("factorial", ctr.calculateFactorial());
                break;
            default:
                System.out.printf("La opción %s no es válida\n", option);
                break;
        }

    }

    void showResult(String operation, int result) {
        System.out.printf("El resultado de la %s es %s", operation, result);
        System.out.println("");
    }

    void showResult(String operation, double result) {
        System.out.printf("El resultado de la %s es %.2f", operation, result);
        System.out.println("");
    }

    void showResult(String operation, long result) {
        NumberFormat nf = NumberFormat.getInstance(Locale.GERMANY);
        System.out.printf("El factorial de %s es %s", operation, nf.format(result));
        System.out.println("");
    }

    void showAllResults() throws BusinessException {
        System.out.printf("Operaciones con %s y %s\n", number1, number2);
        showResult("suma", ctr.add());
        showResult("resta", ctr.subtract());
        showResult("producto", ctr.multiply());
        showResult("división", ctr.intDivide());
        showResult("resto", ctr.restDivision());
    }

    void show() {
        Scanner scanner = new Scanner(System.in);
        boolean wantContinue = true;

        while (wantContinue) {
            showMenu();
            try {
                int answer = scanner.nextInt();

                if (answer == 0) {
                    wantContinue = false;
                } else if (answer == 1) {
                    number1 = getInteger(" Dime el primer número");
                    ctr.setNum1(number1);
                } else if (answer == 2) {
                    number2 = getInteger(" Dime el segundo número");
                    ctr.setNum2(number2);
                } else {
                    calculate(answer);
                }

            } catch (InputMismatchException e) {
                System.out.println("Tipo de dato no válido como opción");
                scanner = new Scanner(System.in);
            } catch (BusinessException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
        System.out.println("Gracias por todo");
    }
}