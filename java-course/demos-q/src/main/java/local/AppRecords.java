package local;

import local.repositories.RecordDAO;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import local.entities.Record;

public class AppRecords {
    static RecordDAO dao = new RecordDAO();

    private static void showList(Collection<Record> collection) {
        if (collection == null || collection.isEmpty()) {
            System.out.println("No items found.");
            return;
        }
        System.out.println("Records: [");
        collection.forEach(item -> System.out.println(item.toString(true)));
        System.out.println("]");
        System.out.println();
    }

    private static void showOptional(Optional<Record> optionalRoom) {
        optionalRoom.ifPresentOrElse(
                //
                item -> System.out.println(item.toString(true)),
                //
                () -> System.out.println("Sala no encontrada"));

    }

    private static void showRecords() {
        System.out.println("----------- Find All -----------");
        List<Record> records = dao.findAll();
        showList(records);

        System.out.println("----------- Find by ID valid -----------");
        showOptional(dao.findById(records.get(0).getId()));
        System.out.println("----------- Find by ID invalid -----------");
        showOptional(dao.findById(UUID.fromString("2a0cd5b5-1c2f-41d0-bc00-96bc7f9176c5")));
    }


    @SuppressWarnings("unused")
    private static void checkRecords() {
        Record record1 = dao.save(new Record("Info de una reunion"));
        Record record2 = dao.save(new Record("Info de otra reunion"));

        System.out.println("----------- Find All -----------");
        System.out.println(dao.findAll());
        System.out.println("----------- Find by ID valid -----------");
        System.out.println(dao.findById(record1.getId()));
        System.out.println("----------- Find by ID invalid -----------");
        System.out.println(dao.findById(UUID.fromString( "2a0cd5b5-1c2f-41d0-bc00-96bc7f9176c5")));


        System.out.println("----------- Delete by ID 1 (si existe)-----------");

        dao.findById(record1.getId()).ifPresentOrElse(
            dao::delete,
            () -> System.out.println("Record no encontrada: no se ha podido eliminar"));
            System.out.println("----------- Find All after delete -----------");
            System.out.println(dao.findAll());

        try {
            Record p3 = dao.findById(record2.getId()).orElseThrow(() -> new RuntimeException("Record no encontrado"));
            dao.detach(p3);
            System.out.println("----------- Update by ID 2 -----------");
            p3.setContent("Info Actualizada de la reunión");
            dao.update(p3);
            System.out.println("----------- Find All after update -----------");
            System.out.println(dao.findAll());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        System.out.println("Records application");
        // checkRecords();
        showRecords();
    }
}
