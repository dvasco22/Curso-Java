
/*package local.concept1;

public class Concept1 {

    public static void useTryCatch() {
        Square sq1 = new Square(10);
        Square sq2 = sq1;
        System.out.println(sq1);
        System.out.println(sq2);
        try {
            Square sq3 = (Square) sq1.clone();
            System.out.println(sq3);
            System.out.println(sq1 == sq3); // false
            System.out.println(sq1.equals(sq3)); // true

        } catch (CloneNotSupportedException e) {
            System.out.println("No se ha podido clonar el objeto");
        } catch (Exception e) {
            System.out.println("Algo imprevisto ha ocurrido");
        }
        System.out.println("Gracias por usar mi programa");
    }

    public static void unHandle() throws CloneNotSupportedException {
        Square sq1 = new Square(10);
        Square sq2 = sq1;
        System.out.println(sq1);
        System.out.println(sq2);
        Square sq3 = (Square) sq1.clone();
        System.out.println(sq3);
        System.out.println("Gracias por usar mi programa");

    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        useTryCatch();
        // unHandle();
    }
}*/

package local.concept1;

public class Concept1 {

    public static void useTryCatch() {
        Square sq1 = new Square(10);
        Square sq2 = sq1;
        System.out.println(sq1);
        System.out.println(sq2);
        try {
            Square sq3 = (Square) sq1.clone();
            System.out.println(sq3);
            System.out.println(sq1 == sq3); // false
            System.out.println(sq1.equals(sq3)); // true

        } catch (CloneNotSupportedException e) {
            System.out.println("No se ha podido clonar el objeto");
        } catch (Exception e) {
            System.out.println("Algo imprevisto ha ocurrido");
        }
        System.out.println("Gracias por usar mi programa");
    }

    public static void unHandle() throws CloneNotSupportedException {
        Square sq1 = new Square(10);
        Square sq2 = sq1;
        System.out.println(sq1);
        System.out.println(sq2);
        Square sq3 = (Square) sq1.clone();
        System.out.println(sq3);
        System.out.println("Gracias por usar mi programa");

    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        useTryCatch();
        // unHandle();
    }
}