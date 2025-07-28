package local;

import java.util.Collection;
import java.util.Optional;

import local.entities.Room;
import local.repositories.RoomDAO;

public class AppRooms {
    static RoomDAO dao = new RoomDAO();

    private static void showList(Collection<Room> collection) {
        if (collection == null || collection.isEmpty()) {
            System.out.println("No items found.");
            return;
        }
        System.out.println("Rooms: [");
        collection.forEach(item -> System.out.println(item.toString(true)));
        System.out.println("]");
        System.out.println();
    }

    private static void showOptional(Optional<Room> optionalItem) {
        optionalItem.ifPresentOrElse(
                //
                item -> System.out.println(item.toString(true)),
                //
                () -> System.out.println("Sala no encontrada"));

    }

    private static void showRooms() {
        System.out.println("----------- Find All -----------");
        showList(dao.findAll());
        System.out.println("----------- Find by ID valid -----------");
        showOptional(dao.findById("S0101"));
        System.out.println("----------- Find by ID invalid -----------");
        showOptional(dao.findById(100));

    }

    @SuppressWarnings("unused")
    private static void checkRooms() {

        System.out.println("----------- Delete by ID S0201 (si existe)-----------");

        dao.findById("S0101").ifPresentOrElse(dao::delete,
                () -> System.out.println("Sala no encontrada: no se ha podido eliminar"));
        dao.findById("S0201").ifPresentOrElse(dao::delete,
                () -> System.out.println("Sala no encontrada: no se ha podido eliminar"));

        try {
            dao.save(new Room("S0101", "Sala principal", 10));
        } catch (Exception e) {
            System.out.println("Salas ya creadas");
        }
        dao.save(new Room("S0201", "Sala pequeña", 5));

        System.out.println("----------- Find All -----------");
        System.out.println(dao.findAll());
        System.out.println("----------- Find by ID valid -----------");
        System.out.println(dao.findById(1));
        System.out.println("----------- Find by ID invalid -----------");
        System.out.println(dao.findById(100));

        System.out.println("----------- Delete by ID S0201 (si existe)-----------");

        dao.findById("S0201").ifPresentOrElse(dao::delete,
                () -> System.out.println("Sala no encontrada: no se ha podido eliminar"));
        System.out.println("----------- Find All after delete -----------");
        System.out.println(dao.findAll());

        try {
            Room r1 = new Room("S0101", "Sala principal reformada", 15);
            System.out.println("----------- Update by ID 2 -----------");
            dao.update(r1);
            System.out.println("----------- Find All after update -----------");
            System.out.println(dao.findAll());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        System.out.println("Rooms application");
        // checkRooms();
        showRooms();
    }
}
