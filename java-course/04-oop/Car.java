public class Car {

    String brand;
    char type;
    int numSeats;
    int numDors;
    String color;
    boolean isAuto;

    Car(
            String brand,
            char type,
            int numSeats,
            int numDors,
            String color,
            boolean isAuto) {
        this.brand = brand;
        this.type = type;
        this.numSeats = numSeats;
        this.numDors = numDors;
        this.color = color;
        this.isAuto = isAuto;
    }

    void showInfo() {
        String message = """
                ======================
                Marca: %s
                Tipo: %s;
                Número de asientos %s;
                Número de puertas %s;
                Color %s;
                Is automático: %s;
                =======================
                """;
        System.out.println(message.formatted(
                brand,
                type,
                numSeats,
                numDors,
                color,
                isAuto));
    }

}
