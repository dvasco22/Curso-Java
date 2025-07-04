
package local.concept1;

// Ejemplos de excepciones runtime
// provocadas para probarlas
// !! Código con errores!!

// Excepciones que se muestran:
// IndexOutOfBoundsException
// NullPointerException
// ClassCastException
// NumberFormatException

public class ShowExceptions {

    String name = "Pepe";

    void makeIndexOutOfBoundsException() {
        System.out.println(name.charAt(10));
    }

    @SuppressWarnings("null")
    void makeNullPointerException() {
        Square nada = null;
        nada.toString();
        nada = new Square(0);
    }

    void makeClassCastException() {
        Object x = (Integer) 4;
        System.out.println((String) x);
    }

    void makeNumberFormatException() {
        String s = "4.5";
        int i = Integer.parseInt(s);
        System.out.println(i);
    }

    public static void main(String[] args) {
        ShowExceptions se = new ShowExceptions();
        try {
            se.makeNumberFormatException();
            se.makeClassCastException();
            se.makeIndexOutOfBoundsException();
            se.makeNullPointerException();
        } catch (IndexOutOfBoundsException | NullPointerException | ClassCastException | NumberFormatException e) {
            System.err.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
        System.out.println("Fin del programa");
    }

}
