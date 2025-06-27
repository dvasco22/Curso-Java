
import base.Square;

public class Equality {

    public static void primitives() {
        System.out.println("Valores primitivos");
        byte num1 = 5;
        byte num2 = 5;
        System.out.println(num1 == num2); // true
        short num3 = 5;
        System.out.println(num1 == num3); // true debido al unboxing
        int num4 = 5;
        System.out.println(num1 == num4); // true debido al unboxing
        float num5 = 5.0f;
        System.out.println(num1 == num5); // true
        char char1 = 'a'; // char es -> short (2 bytes)
        char char2 = 'b';
        byte valueA = 97;
        System.out.println(char1 == char2); // false
        System.out.println(char1 == valueA);
        // boolean bool = false;
        // byte likeBool = 0;
        // System.out.println(bool == likeBool);
    }

    public static void wrappers() {
        System.out.println("Wrappers de valores primitivos");
        Integer num1 = 5;// new Integer(5);
        Integer num2 = 5;// new Integer(5);
        System.out.println(num1 == num2); // false
        System.out.println(num1);
        System.out.println(num1.toString());
    }

    public static void casting() {
        System.out.println("Castings y coerción de valores primitivos");

        int num1 = 23;
        byte num2 = 20;
        byte result = (byte) (num1 + num2);
        System.out.println(result);
        String text = "Result ";
        System.out.println(text + (num1 + num2));
        System.out.println((2 * 2) + (4 * 4 / 2));
    }

    public static void compareStrings() {
        System.out.println("Strings and equality");
        String str1 = "Hola mundo";
        String str2 = new String("Hola mundo");
        String str3 = "Hola mundo";
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str3);
        String str4 = str2;
        System.out.println(str2 == str4);

        for (int i = 0; i < str1.length(); i++) {
            System.out.println(str1.charAt(i));
        }

        for (char item : str1.toCharArray()) {
            System.out.println(item);
        }

        System.out.println("_____");
        System.out.println(str1.charAt(5));
        // str1[5] = "M";
        System.out.println(str1.codePointAt(5));
    }

    public static void compareObjects() {
        System.out.println("Objects and equality");

        Square sq1 = new Square(10);
        Square sq2 = new Square(10);
        Square sq3 = sq1;

        System.out.println(sq1 == sq2); // False
        System.out.println(sq3 == sq1); // True
        System.out.println(sq1.toString());
        System.out.println(sq2);
        System.out.println(sq3);
        System.out.println(sq1.equals(sq2)); // True

        sq1.side = 12;
        System.out.println(sq2.side); // 10
        System.out.println(sq3.side); // 12
    }

    public static void main(String[] args) {
        System.out.println("Aprendiendo acerca de la igualdad en Java");
        primitives();
        System.out.println("--------------------------");
        wrappers();
        System.out.println("--------------------------");
        casting();
        System.out.println("--------------------------");
        compareStrings();
        System.out.println("--------------------------");
        compareObjects();

    }

}
