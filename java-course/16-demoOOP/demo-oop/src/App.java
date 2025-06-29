
import animals.Dog;

import animals.Pet;
import base.Person;
import base.Square;
import game.Character;
import game.Role;
import game.Species;

public class App {

    static void playWithPersons() {
        Person person1 = new Person("Pepe", 22);
        // Person.countInstances++;

        // person1.name = "Ramon";
        // person1.age = 20;
        person1.greetings();
        person1.setAge(23);
        person1.greetings();

        Person person2 = new Person("Juan", 25);
        // Person.countInstances++;

        // person2.name = "Juan";
        // person2.age = 25;
        person2.greetings();
        System.out.println(Person.countInstances);
    }

    static void prepareGame() {
        Character char1 = new Character("Pepe", Species.ELFO, 100, 50, Role.MAGO, false);
        char1.showCharacter();
        Character char2 = new Character("Pepe", Species.ORCO, 120, 500, Role.PEON, false);
        char2.showCharacter();

        char1.renameInvalidCharacters("Elfo Pepe");

        Character.showList();
        char2.renameInvalidCharacters("Orco Pepe");
        char2.showCharacter();
        Character.showList();
    }

    public static void playPets() {

        Dog pet1 = new Dog("Rufus", 2);
        System.out.println(pet1 instanceof Dog);
        System.out.println(pet1 instanceof Pet);
        System.out.println(pet1 instanceof Object);

        pet1.sleep();
        pet1.eat();

    }

    public static void main(String[] args) {

        // playWithPersons();
        // prepareGame();
        // playPets();

        Square sq = new Square(10);
        String type = "Cuadrado";
        System.out.println(sq instanceof Object);
        System.out.println(type instanceof Object);
        System.out.println(type);
        System.out.println(sq.toString());

        Square sq2 = new Square(10);
        System.out.println(sq == sq2);

        System.out.println(sq2);

        System.out.println(sq.equals(sq2));

    }
}