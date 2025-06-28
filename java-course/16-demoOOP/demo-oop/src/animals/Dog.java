package animals;

public class Dog extends Pet implements IDog {

    private String name;
    private int age;

    public Dog(String name, int age) {
        super(name, age);
        /*
         * sin herencia
         * this.name = name;
         * this.age = age;
         */
    };

    public Dog(String name) {
        super(name);
        /*
         * sin herencia
         * this.name = name;
         * this.age = 0;
         */
    };

    @Override
    public void eat() {
        // super.eat();
        String message = "Como comida para perros";
        System.out.println(message);
    }

    @Override
    public String makeSounds() {
        String message = "Guau";
        System.out.println(message);
        return message;
    }

}