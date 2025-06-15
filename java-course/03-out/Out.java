
// Formas de imprimir en pantalla

public class Out {

    public static void main(String[] args) {

        String name = "Pepe";
        String surname = "Pérez";
        int age = 33;

        // println -> expresión
        System.out.println("Hola " + name + " " + surname + "\n¿como estás a tus " + age + " años?");

        // printf -> expresión, variables...

        System.out.printf("Hola %s %s\n¿como estás a tus %s años?\n", name, surname, age);

        // println -> template string

        System.out.println("""
                Hola %s %s
                ¿como estás a tus %s años?
                    """.formatted(name, surname, age));

    }
}