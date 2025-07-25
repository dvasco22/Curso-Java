package local;

import local.repositories.RecordDAO;

import java.util.UUID;

import local.entities.Record;

public class AppRecords {

    private static void checkRecords() {
        RecordDAO dao = new RecordDAO();

        dao.save(new Record("Info de una reunion"));
        dao.save(new Record("Info de otra reunion"));

        System.out.println("----------- Find All -----------");
        System.out.println(dao.findAll());
        System.out.println("----------- Find by ID valid -----------");
        System.out.println(dao.findById(UUID.fromString( "5a744b9c-27c7-40e0-8bfc-5c047f170423")));
        System.out.println("----------- Find by ID invalid -----------");
        System.out.println(dao.findById(UUID.fromString( "2a0cd5b5-1c2f-41d0-bc00-96bc7f9176c5")));

        System.out.println("----------- Delete by ID 1 (si existe)-----------");

        dao.findById(UUID.fromString( "5a744b9c-27c7-40e0-8bfc-5c047f170423")).ifPresentOrElse(
            dao::delete,
            () -> System.out.println("Record no encontrada: no se ha podido eliminar"));
            System.out.println("----------- Find All after delete -----------");
            System.out.println(dao.findAll());

        try {
            Record p3 = dao.findById(UUID.fromString("6436ae06-b147-4e88-89b7-e87ed6cfc9b3")).orElseThrow(() -> new RuntimeException("Record no encontrado"));
            
            ////////////////////
            dao.detach(p3);
            // TODO implement detach() 

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
        checkRecords();
    }
}