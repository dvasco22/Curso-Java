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

    @SuppressWarnings("resource")
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
                9. Otras operaciones
                0. Salir """.formatted(number1, number2);

        System.out.println(menu);
    }

    private void showMenu2() {
        String menu = """

                Elige el número de la opción que quieras
                ----------------------------------------
                1. Dime un número entero (%s)
                2. Dime otro número entero (%s)
                3. Calcula el factorial del primero
                4. Calcula el factorial del segundo
                5. Calcula es primero elevado al segundo
                6. Calcula el segundo elevado al primero
                7. ...
                8. Calcula todos los anteriores (Pendiente)
                9. Volver al menu anterior
                0. Salir """.formatted(number1, number2);

        System.out.println(menu);
    }

    private void calculate(int option) throws BusinessException {

        switch (option) {
            case 3:
                showResult("la suma", ctr.add());
                break;
            case 4:
                showResult("la resta", ctr.subtract());
                break;
            case 5:
                showResult("el producto", ctr.multiply());
                break;
            case 6:
                showResult("la división", ctr.intDivide());
                showResult("el resto", ctr.restDivision());
                break;
            case 7:
                showResult("la división", ctr.decimalDivide());
                break;
            case 8:
                showAllResults();
                break;
            // case 9:
            // showResult("factorial", ctr.calculateFactorial());
            // break;
            default:
                System.out.printf("La opción %s no es válida\n", option);
                break;
        }

    }

    private void calculate2(int option) throws BusinessException {

        switch (option) {
            case 3:
                // TODO comprobar posibles problemas del cast
                showResult("factorial", ctr.calculateFactorial((byte) 1), number1);
                break;
            case 4:
                showResult("factorial", ctr.calculateFactorial((byte) 2), number2);
                break;
            case 5:
                showResult("%s elevado a %s".formatted(number1, number2), ctr.pow());
                break;
            case 6:
                showResult("%s elevado a %s".formatted(number2, number1), ctr.pow(number2, number1));
                break;
            case 7:
                /// showResult("división", ctr.decimalDivide());
                break;
            case 8:
                // showAllResults();
                break;
            default:
                System.out.printf("La opción %s no es válida\n", option);
                break;
        }

    }

    private void showResult(String operation, int result) {
        System.out.printf("El resultado de %s es %s", operation, result);
        System.out.println("");
    }

    private void showResult(String operation, double result) {
        System.out.printf("El resultado de %s es %.2f", operation, result);
        System.out.println("");
    }

    private void showResult(String operation, long result, int number) {
        NumberFormat nf = NumberFormat.getInstance(Locale.GERMANY);
        System.out.printf("El %s de %s es %s", operation, number, nf.format(result));
        System.out.println("");
    }

    private void showAllResults() throws BusinessException {
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
                    scanner.close();
                    System.out.println("Gracias por todo");
                    System.exit(0);
                } else if (answer == 1) {
                    number1 = getInteger(" Dime el primer número");
                    ctr.setNum1(number1);
                } else if (answer == 2) {
                    number2 = getInteger(" Dime el segundo número");
                    ctr.setNum2(number2);
                } else if (answer == 9) {
                    show(true);
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
    }

    void show(boolean alt) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        boolean wantContinue = true;

        while (wantContinue) {
            showMenu2();

            int answer = scanner.nextInt();

            if (answer == 0) {
                System.out.println("Gracias por todo");
                System.exit(0);
            } else if (answer == 1) {
                number1 = getInteger(" Dime el primer número");
                ctr.setNum1(number1);
            } else if (answer == 2) {
                number2 = getInteger(" Dime el segundo número");
                ctr.setNum2(number2);
            } else if (answer == 9) {
                wantContinue = false;
            } else {
                try {
                    calculate2(answer);
                } catch (BusinessException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        show();

    }
}
