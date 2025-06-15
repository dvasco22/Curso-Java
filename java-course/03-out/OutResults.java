// Formas de imprimir en pantalla
// guardándolo previamente en una variable

public class OutResults {

    public static void main(String[] args) {

        String name = "Pepe";
        String surname = "Pérez";
        int age = 33;

        // println -> expresión
        String result = "Hola " + name + " " + surname + "\n¿como estás a tus " + age + " años?";
        System.out.println(result);

        // printf -> expresión, variables...
        result = "Hola %s %s\n¿como estás a tus %s años?\n";
        System.out.printf(result, name, surname, age);

        // println -> template string
        result = """
                Hola %s %s
                ¿como estás a tus %s años?
                    """;
        System.out.println(result.formatted(name, surname, age));

    }

}
