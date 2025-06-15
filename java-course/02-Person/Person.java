public class Person {

    // Tipos de números byte-1 byte-128-127 short-2 bytes int-4 bytes long-8 bytes
    // float-decimal 4 bytes double-decimal 8 bytes

    public static void main(String[] args) {

        byte age; // Declaración
        age = 22; // Asignación
        short birthYear = 1990; // Inicialización = Declaración + Asignación
        int cityPopulation = 4_000_000;
        long countryPopulation = 40_000_000;
        float height = 1.78f;
        double weight = 65.74;
        boolean hasPet = true;
        char type = 'A';
        String name = "Pepe";
        // salto de linea
        System.out.println("Edad " + age);
        System.out.println("Fecha " + birthYear);
        System.out.println("Población de mi ciudad " + cityPopulation);
        System.out.println("Población de mi país " + countryPopulation);
        System.out.println("""
                Altura %s mts
                Peso %s kgs
                ¿Tiene mascotas? %s

                Tipo %s
                Nombre %s
                """.formatted(height, weight, hasPet, type, name));
    }

}