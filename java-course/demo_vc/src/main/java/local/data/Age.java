package local.data;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Age {
    private String birthDateStr;
    private int years;
    private int months;
    private int days;

    void calculaAge(String birthDateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDay = LocalDate.parse(birthDateStr, formatter);
        LocalDate actualDate = LocalDate.now();
        Period period = Period.between(birthDay, actualDate);
        years = period.getYears();
        months = period.getMonths();
        days = period.getDays();
    }

    void calculaAge() {
        calculaAge(this.birthDateStr);
    }

    void getBirthDateCLI() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su fecha de nacimiento (formato: dd/MM/yyyy):");
        birthDateStr = scanner.nextLine();
        scanner.close();
    }

    @Override
    public String toString() {
        return "Usted tiene: " + years + " años, " + months + " meses y " + days + " días.";
        // "Age [years=" + years + ", months=" + months + ", days=" + days + "]";
    }

    public static void main(String[] args) {
        Age age = new Age();

        try {
            age.getBirthDateCLI();
            age.calculaAge();
            System.out.println(age);
        } catch (Exception e) {
            System.out.println("Formato de fecha incorrecto. Use dd/MM/yyyy.");
        }
    }

}