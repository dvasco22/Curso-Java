package local;

import java.util.Collection;
import java.util.Optional;

import local.entities.Person;
import local.repositories.PersonDAO;

public class AppPersons {

    private static PersonDAO dao = new PersonDAO();

    private static void showList(Collection<Person> collection) {
        if (collection == null || collection.isEmpty()) {
            System.out.println("No items found.");
            return;
        }
        System.out.println("Persons: [");
        collection.forEach(item -> System.out.println(item.toString(true)));
        System.out.println("]");
        System.out.println();
    }

    private static void showOptional(Optional<Person> optional) {
        optional.ifPresentOrElse(
                //
                item -> System.out.println(item.toString(true)),
                //
                () -> System.out.println("Persona no encontrada"));
    }

    private static void showPersons() {
        System.out.println("----------- Find All -----------");
        showList(dao.findAll());

        System.out.println("----------- Find by ID valid -----------");
        showOptional(dao.findById(2));

        System.out.println("----------- Find by ID invalid -----------");
        showOptional(dao.findById(100));

    }

    @SuppressWarnings("unused")
    private static void checkPersons() {

        dao.save(new Person("Pepe", "Perez", "pp@sample.com"));
        dao.save(new Person("Luisa", "Gomez", "lg@sample.com"));

        System.out.println("----------- Find All -----------");
        showList(dao.findAll());
        System.out.println("----------- Find by ID valid -----------");
        showOptional(dao.findById(1));
        System.out.println("----------- Find by ID invalid -----------");
        showOptional(dao.findById(100));

        System.out.println("----------- Delete by ID 1 (si existe)-----------");

        dao.findById(1).ifPresentOrElse(dao::delete,
                () -> System.out.println("Persona no encontrada: no se ha podido eliminar"));
        System.out.println("----------- Find All after delete -----------");
        showList(dao.findAll());

        try {
            Person p3 = dao.findById(4).orElseThrow(() -> new RuntimeException("Persona no encontrada"));
            dao.detach(p3);
            System.out.println("----------- Update by ID 2 -----------");
            p3.setEmail("new@sample.com");
            dao.update(p3);
            System.out.println("----------- Find All after update -----------");
            showList(dao.findAll());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        System.out.println("Persons application");
        // checkPersons();
        showPersons();
    }
}
