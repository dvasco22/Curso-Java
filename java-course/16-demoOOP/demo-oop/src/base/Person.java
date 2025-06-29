package base;

public class Person {

    // Propiedades static o de clase
    public static int countInstances = 0;

    // Métodos static o de clase
    public static void updateCounter() {
        countInstances++;
    }

    // Propiedades de instancia
    private String name;
    private int age;

    // Métodos getters y setters
    // public String getName() {
    // return name;
    // }

    // public void setName(String name) {
    // this.name = name;
    // }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < this.age) {
            return;
        }
        this.age = age;
    }

    // Método Constructor
    public Person(String name, int age) {
        System.out.println("Se ha instanciado una Person");
        this.name = name;
        this.age = age;
        updateCounter();
    }

    // Método de instancia
    public void greetings() {
        System.out.printf("Hola soy %s y tengo %s años.\n", name, age);
    }

}