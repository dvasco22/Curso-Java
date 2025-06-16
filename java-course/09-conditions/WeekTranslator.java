
import java.util.Scanner;

public class WeekTranslator {

    static String getDayByScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dime un día de la semana en español");
        String day = scanner.nextLine();
        System.out.println("");
        scanner.close();
        return day;
    }

    public static void main(String[] args) {

        String day = getDayByScanner();

        switch (day.toLowerCase()) {
            case "lunes":
                System.out.println("hétfő");
                break;
            case "martes":
                System.out.println("kedd");
                break;
            case "miercoles":
            case "miércoles":
                System.out.println("szerda");
                break;
            case "jueves":
                System.out.println("csütörtök");
                break;
            case "viernes":
                System.out.println("péntek");
                break;
            case "sabado":
            case "sábado":
                System.out.println("szombat");
                break;
            case "domingo":
                System.out.println("vasárnap");
                break;
            default:
                System.out.println("No es un día en español");
                break;
        }

    }

}
