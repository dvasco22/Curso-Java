package animals;

public abstract class Pet implements IPet {

    private String name;
    private int age;

    // public Pet() {};

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    };

    public Pet(String name) {
        this.name = name;
        this.age = 0;
    };

    @Override
    public void sleep() {
        System.out.println("Estoy durmiendo");
    }

    @Override
    public void eat() {
        System.out.println("Estoy comiendo");
    }

    @Override
    public void eat(int n) {
        System.out.println("Estoy comiendo");
    }

    @Override
    public abstract String makeSounds();

}
