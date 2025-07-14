package local.data;

import java.util.Arrays;

@SuppressWarnings("unused")
public class Text {

    void useString() {
        String text = "Hello, World!";
        System.out.println(text);
        System.out.println("Length: " + text.length());
        System.out.println("Lowercase: " + text.toLowerCase());
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Substring (0, 5): " + text.substring(0, 5));
        System.out.println("Contains 'World': " + text.contains("World"));
        // Otros métodos de String
        // text.indexOf("World")); // Encuentra la posición de una subcadena
        System.out.println("Index of 'World': " + text.indexOf("World"));
        // text.lastIndexOf("o")); // Encuentra la última posición de un carácter
        System.out.println("Last index of 'o': " + text.lastIndexOf("o"));
        // text.replace("World", "Java"); // Reemplaza una subcadena
        System.out.println("Replace 'World' with 'Java': " + text.replace("World", "Java"));
        // text.startsWith("Hello")); // Verifica si comienza con una subcadena
        System.out.println("Starts with 'Hello': " + text.startsWith("Hello"));
        // text.endsWith("!")); // Verifica si termina con una subcadena
        System.out.println("Ends with '!': " + text.endsWith("!"));
        // text.trim(); // Elimina espacios en blanco al inicio y al final
        System.out.println("Trimmed: '" + text.trim() + "'");
        // text.split(","); // Divide la cadena en un array de subcadenas
        System.out.println("Split by ',': " + Arrays.toString(text.split(",")));
        // text.toCharArray(); // Convierte la cadena en un array de caracteres
        System.out.println("To char array: " + Arrays.toString(text.toCharArray()));
        // text.charAt(0); // Obtiene el carácter en una posición específica
        System.out.println("Char at index 0: " + text.charAt(0));
        // text.isEmpty(); // Verifica si la cadena está vacía
        System.out.println("Is empty: " + text.isEmpty());
        // text.equals("Hello, World!"); // Compara con otra cadena
        System.out.println("Equals 'Hello, World!': " + text.equals("Hello, World!"));
        // text.equalsIgnoreCase("hello, world!"); // Compara ignorando mayúsculas y
        // minúsculas
        System.out.println("Equals ignore case 'hello, world!': " + text.equalsIgnoreCase("hello, world!"));
        // text.compareTo("Hello, World!"); // Compara lexicográficamente
        System.out.println("Compare to 'Hello, World!': " + text.compareTo("Hello, World!"));
        // text.compareToIgnoreCase("hello, world!"); // Compara lexicográficamente
        // ignorando mayúsculas y minúsculas
        System.out.println("Compare to ignore case 'hello, world!': " + text.compareToIgnoreCase("hello, world!"));
        // text.format("Formatted: %s", text); // Formatea la cadena
        System.out.println("Formatted: " + String.format("Formatted: %s", text));
        // text.intern(); // Interna la cadena (almacena en pool de cadenas)
        System.out.println("Interned: " + text.intern());
        // text.codePointAt(0); // Obtiene el punto de código Unicode en una posición
        // específica
        System.out.println("Code point at index 0: " + text.codePointAt(4));
        // text.toString(); // Convierte a String (aunque ya es
        System.out.println("To String: " + text.toString());
        // test.valueOf(text)); // Convierte a String (aunque ya es)
        System.out.println("Value of: " + String.valueOf(text));
    }

    void useStringBuffer() {
        StringBuffer sb = new StringBuffer("Hello");
        String text = "Hello";
        StringBuffer sbText = new StringBuffer(text);
        sbText.append(" - " + text);
        System.out.println(sbText);
        System.out.println(sbText.hashCode());
        sbText.insert(7, "x");
        System.out.println(sbText);
        System.out.println(sbText.hashCode());
        sbText.replace(6, 8, "x");
        System.out.println(sbText);
        System.out.println(sbText.hashCode());
        sbText.delete(6, 7);
        System.out.println(sbText.toString());
        // Otros métodos de StringBuffer
        // sb.reverse(); // Invierte el contenido
        System.out.println(sb.reverse());
        // sb.capacity(); // Capacidad del buffer
        System.out.println("Capacity: " + sb.capacity());
        sb.ensureCapacity(50); // Asegura una capacidad mínima
        System.out.println("New Capacity: " + sb.capacity());
        sb.trimToSize(); // Ajusta la capacidad al tamaño actual
        System.out.println("Trimmed Capacity: " + sb.capacity());
        // sb.setLength(10); // Establece una nueva longitud
        // System.out.println("New Length: " + sb.length());
        // sb.charAt(0); // Obtiene el carácter en una posición específica
        System.out.println("Character at index 0: " + sb.charAt(0));
        // sb.indexOf("World"); // Encuentra la posición de una subcadena
        System.out.println("Index of 'World': " + sb.indexOf("World"));
        // sb.lastIndexOf("o"); // Encuentra la última posición de un carácter
        System.out.println("Last index of 'o': " + sb.lastIndexOf("o"));
        // sb.toString(); // Convierte a String
        System.out.println("String representation: " + sb.toString());
    }

    void useStringBuilder() {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(", World!");
        System.out.println(sb.toString());
        sb.insert(5, " Beautiful");
        System.out.println(sb.toString());
        sb.replace(0, 5, "Hi");
        System.out.println(sb.toString());
        sb.delete(0, 3);
        System.out.println(sb.toString());
        // Otros métodos de StringBuilder
        // sb.reverse(); // Invierte el contenido
        // System.out.println(sb.toString());
        // sb.capacity(); // Capacidad del buffer
        // System.out.println("Capacity: " + sb.capacity());
        // sb.ensureCapacity(50); // Asegura una capacidad mínima
        // System.out.println("New Capacity: " + sb.capacity());
        // sb.trimToSize(); // Ajusta la capacidad al tamaño actual
        // System.out.println("Trimmed Capacity: " + sb.capacity());
        // sb.setLength(10); // Establece una nueva longitud
        // System.out.println("New Length: " + sb.length());
        // sb.charAt(0); // Obtiene el carácter en una posición específica
        // System.out.println("Character at index 0: " + sb.charAt(0));
        // sb.indexOf("World"); // Encuentra la posición de una subcadena
        // System.out.println("Index of 'World': " + sb.indexOf("World"));
        // sb.lastIndexOf("o"); // Encuentra la última posición de un carácter
        // System.out.println("Last index of 'o': " + sb.lastIndexOf("o"));
        // sb.toString(); // Convierte a String
        // System.out.println("String representation: " + sb.toString());
    }

    public static void main(String[] args) {
        Text text = new Text();
        // text.useString();
        text.useStringBuffer();
    }

}