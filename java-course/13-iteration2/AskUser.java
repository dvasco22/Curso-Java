import java.util.Scanner;

public class AskUser {

    static void ask() {
        Scanner keyBoard = new Scanner(System.in);
        boolean wantContinue = true;

        while (wantContinue) {

            System.out.println("¿Quieres continuar (S/N)?");
            String answer = keyBoard.nextLine();
            if (answer.toLowerCase().equals("n") || answer.toLowerCase().equals("no"))
                wantContinue = false;

        }

        keyBoard.close();
    }

    static void ask2() {
        Scanner keyBoard = new Scanner(System.in);
        String answer = "S";

        while (!answer.toLowerCase().equals("n") && !answer.toLowerCase().equals("no")) {

            System.out.println("¿Quieres continuar (S/N)?");
            answer = keyBoard.nextLine();
        }

        keyBoard.close();

    }

    public static void main(String[] args) {
        ask();
        // ask2();
    }

}