import java.util.Scanner;

public class Args {

    static int getAgeByCommandLine(String[] args) {

        if (args.length == 0) {
            System.out.println("Tienes que añadir un entero en la línea de comandos");
            return -1;
        }

        int age = Integer.valueOf(args[0]);
        return age;
    }

    static int getAgeByKeyboard() {
        Scanner keyBoard = new Scanner(System.in);
        System.out.println("Dime la edad del alumno");
        int age = keyBoard.nextInt();
        System.out.println("");
        keyBoard.close();
        return age;
    }

    public static void main(String[] args) {

        String[] messages = {
                "Kinder (de 6 años inclusive): Lunes y Miércoles de 16 a 17",
                "1st Year (de 7 a 8 años inclusive): Martes y Jueves de 16:30 a 17:30",
                "2nd Year (de 9 a 1O años inclusive): Martes y Jueves de 17:30 a 19",
                "3rd Year (de ll a 13 años inclusive): Lunes y Miércoles de 17 a 18:30",
                "No tenemos clases para mayores de 13 años"
        };

        // int studentAge = getAgeByKeyboard();

        int studentAge = getAgeByCommandLine(args);

        int index = 4;

        if (studentAge < 0) {
            return;
        } else if (studentAge <= 6) {
            index = 0;
        } else if (studentAge <= 8) {
            index = 1;
        } else if (studentAge <= 10) {
            index = 2;
        } else if (studentAge <= 13) {
            index = 3;
        }

        // int index = (studentAge <= 6) ? 0 :
        // (studentAge <= 8) ? 1 :
        // (studentAge <= 10) ? 2 :
        // (studentAge <= 13) ? 3 : 4;

        System.out.println(messages[index]);
    }
}
