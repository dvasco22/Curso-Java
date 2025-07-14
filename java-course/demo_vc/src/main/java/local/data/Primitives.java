package local.data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Formatter;
import java.util.Locale;

@SuppressWarnings("unused")
public class Primitives {

    void makePrimitives() {

        byte byteNumber = 1;
        short shortNumber = 1;
        int integerNumber = 1;
        long longNumber = 1;
        float floatNumber = 1;
        double doubleNumber = 1;
        char character = 1;
        boolean booleanValue = true;

        shortNumber = byteNumber;
        byteNumber = (byte) shortNumber;
        // byteNumber = (byte) booleanValue; // Cast imposible
        byteNumber = (byte) integerNumber;
        byteNumber = (byte) longNumber;
        byteNumber = (byte) floatNumber;
        byteNumber = (byte) doubleNumber;
        byteNumber = (byte) character;

    }

    void Wrappers() {
        // Integer iObj = new Integer(1);

        // Autoboxing
        Byte byteObj = 1; // byte -> Byte
        Short shortObj = 1; // short -> Short
        Integer integerObj = 1; // int -> Integer
        Long longObj = 1L; // long -> Long
        Float floatObj = 1.0f; // float -> Float
        Double doubleObj = 1.0d; // double -> Double
        Character charObj = 'A'; // char -> Character
        Boolean booleanObj = true; // boolean -> Boolea

        // Unboxing
        byte byteNumber = byteObj; // Byte -> byte
        short shortNumber = shortObj; // Short -> short
        int integerNumber = integerObj; // Integer -> int
        long longNumber = longObj; // Long -> long
        float floatNumber = floatObj; // Float -> float
        double doubleNumber = doubleObj; // Double -> double
        char character = charObj; // Character -> char
        boolean booleanValue = booleanObj; // Boolean -> boolean
    }

    void numbersRanges() {

        NumberFormat nf = NumberFormat.getInstance(Locale.GERMANY);

        System.out.println("-----------------------------------------------------------");
        System.out.println("Max and Min values of primitive types:");
        System.out.println("Byte: " + Byte.MAX_VALUE + ", " + Byte.MIN_VALUE);
        System.out.println("Short: " + Short.MAX_VALUE + ", " + Short.MIN_VALUE);
        System.out.println("Integer: " + Integer.MAX_VALUE + ", " + Integer.MIN_VALUE);
        System.out.println("Integer: " + nf.format(Integer.MAX_VALUE) + ", " + nf.format(Integer.MIN_VALUE));
        System.out.println("Long: " + Long.MAX_VALUE + ", " + Long.MIN_VALUE);
        System.out.println("Long: " + nf.format(Long.MAX_VALUE) + ", " + nf.format(Long.MIN_VALUE));
        System.out.println("Float: " + Float.MAX_VALUE + ", " + Float.MIN_VALUE);
        System.out.println("Float: " + nf.format(Float.MAX_VALUE) + ", " + nf.format(Float.MIN_VALUE));
        System.out.println("Double: " + Double.MAX_VALUE + ", " + Double.MIN_VALUE);
        System.out.println("Double: " + nf.format(Double.MAX_VALUE) + ", " + nf.format(Double.MIN_VALUE));
        // No hay formato para char y boolean
        System.out.println("Character: " + Character.MAX_VALUE + ", " + Character.MIN_VALUE);
        System.out.println("Boolean: " + Boolean.TRUE + ", " + Boolean.FALSE);
        System.out.println("-----------------------------------------------------------");
    }

    void bigNumbers() {

        NumberFormat nf = NumberFormat.getInstance(Locale.GERMANY);

        // BigDecimal y BigInteger
        BigDecimal bigDecimal = new BigDecimal("12345678901234567890.12345678901234567890");
        BigInteger bigInteger = new BigInteger("12345678901234567890");

        System.out.println("BigDecimal: " + nf.format(bigDecimal));
        System.out.println("BigInteger: " + nf.format(bigInteger));

        // Operaciones con BigDecimal
        BigDecimal result = bigDecimal.add(new BigDecimal("1.0"));
        System.out.println("Resultado de la suma: " + result);

    }

    void genericNumber() {
        Number numberObj = 2;
        long longObj = numberObj.longValue();

    }

    void formats() {
        // Formatos de salida
        System.out.printf("byte: %d, short: %d, int: %d, long: %d, float: %.2f, double: %.2f, char: %c, boolean: %b%n",
                (byte) 1, (short) 1, 1, 1L, 1.0f, 1.0d, 'A', true);

        System.out.printf("byte: %s, short: %s, int: %s, long: %s, float: %.2f, double: %.2f, char: %s, boolean: %s%n",
                (byte) 1, (short) 1, 1, 1L, 1.0f, 1.0d, 'A', true);

        Formatter formatter = new Formatter();
        formatter.format("byte: %d, short: %d, int: %d, long: %d, float: %.2f, double: %.2f, char: %c, boolean: %b%n",
                (byte) 1, (short) 1, 1, 1L, 1.0f, 1.0d, 'A', true);
        System.out.println(formatter);
        formatter.close();

        NumberFormat nf = NumberFormat.getInstance(Locale.GERMANY);
        System.out.printf("Número formateado: %s%n", nf.format(1234567.89));

        // chcp 65001` to switch the command prompt encoding to UTF-8
        NumberFormat cf = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        System.out.printf("Número formateado como moneda: %s%n", cf.format(1234567.89));
    }

    public static void main(String[] args) {
        Primitives primitives = new Primitives();
        primitives.numbersRanges();
        primitives.bigNumbers();
        primitives.formats();
    }

}