package local.collections;

public class Person implements Comparable<Person> {

    public static int countInstances = 0;

    public static void updateCounter() {
        countInstances++;
    }

    private String name;
    private String surname;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < this.age) {
            return;
        }
        this.age = age;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        updateCounter();

    }

    private String getFullName() {
        return name + " " + surname;
    }

    public void greetings() {
        System.out.printf("Hola soy %s y tengo %s años.\n", getFullName(), age);
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", surname=" + surname + ", age=" + age + "]";
    }

    @Override
    public int compareTo(Person other) {
        // Ordena por nombre ascendente
        // return this.name.compareTo(other.name);
        // Ordena por apellido ascendente
        // return this.surname.compareTo(other.surname);
        // Ordena por edad ascendente
        // return this.age - other.age;
        // Ordena por apellido y luego por nombre
        int nameComparison = this.surname.compareTo(other.surname);

        if (nameComparison != 0) {
            return nameComparison;
        }

        return this.name.compareTo(other.name);
    }

}