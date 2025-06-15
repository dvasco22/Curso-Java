
public class Week {

    public static void main(String[] args) {

        int day = 6;

        // if (day == 1) {
        // System.out.println("Lunes");
        // } else if (day == 2) {
        // System.out.println("Martes");
        // } else if (day == 3) {
        // System.out.println("Miércoles");

        // } else if (day == 4) {
        // System.out.println("Jueves");

        // } else if (day == 5) {
        // System.out.println("Viernes");
        // } else {
        // System.out.println("Fin de semana");
        // }

        switch (day) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miércoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
            case 7:
                System.out.println("Fin de semana ");
                break;
            default:
                System.out.println("Número no válido");
                break;
        }

    }

}
