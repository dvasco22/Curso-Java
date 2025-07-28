package local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import local.entities.IEntities;
import local.entities.Meeting;
import local.repositories.MeetingDAO;;

public final class AppMeetings {
    private static MeetingDAO meetingDAO = new MeetingDAO();

    public static <T extends IEntities> void showList(Collection<T> collection, String className) {

        if (collection == null || collection.isEmpty()) {
            System.out.println("No items found.");
            return;
        }
        System.out.println(className + ": [");
        collection.forEach(item -> System.out.println(item.toString(true)));
        System.out.println("]");
        System.out.println();
    }

    public static <T extends IEntities> void showOptional(Optional<T> optional, String entityName) {
        optional.ifPresentOrElse(
                //
                item -> System.out.println(item.toString(true)),
                //
                () -> System.out.println(entityName + " no encontrada"));

    }

    private static void showMeetings() {
        System.out.println("----------- Find All -----------");
        showList(meetingDAO.findAll(), "Meetings");
        // meetingDAO.findAll().forEach(item -> {
        // System.out.println(item.toString(true));
        // });

        System.out.println("----------- Find by date -----------");
        List<Meeting> m = meetingDAO.findByDate(LocalDate.of(2025, 07, 25));
        showList(m, "Meetings");
        System.out.println("----------- Next meeting -----------");
        Optional<Meeting> m1 = meetingDAO.nextMeetingBasic();
        showOptional(m1, "Reunión");
    }

    @SuppressWarnings("unused")
    private static void checkMeetingInitial() {

        Meeting m1 = meetingDAO.save(new Meeting("Primera reunion", LocalDateTime.now().plusDays(2)));
        Meeting m2 = meetingDAO.save(new Meeting("Segunda reunion", LocalDateTime.now().plusDays(3)));
        System.out.println(m1);
        System.out.println(m2);

        System.out.println("----------- Find All -----------");
        showList(meetingDAO.findAll(), "Meetings");
        System.out.println("----------- Find by ID valid -----------");
        showOptional(meetingDAO.findById(1), "Reunion");
        System.out.println("----------- Find by ID invalid -----------");
        showOptional(meetingDAO.findById(100),"Reunion");

        System.out.println("----------- Delete by ID 1 (si existe)-----------");
        // try {
        // meetingDAO.delete(meetingDAO.findById(2).get());
        // } catch (Exception e) {
        // System.out.println("Meeting ya eliminado");
        // }

        meetingDAO.findById(1).ifPresentOrElse(entity -> meetingDAO.delete(entity),
                () -> System.out.println("Reunión no encontrada: no se ha podido eliminar"));
        System.out.println("----------- Find All after delete -----------");
        System.out.println(meetingDAO.findAll());

        try {
            Meeting m3 = meetingDAO.findById(3).orElseThrow(() -> new RuntimeException("Meeting not found"));
            meetingDAO.detach(m3);
            System.out.println("----------- Update by ID 2 -----------");
            m3.setDescription("Reunion actualizada");
            m3.setDate(LocalDateTime.now().plusDays(4));
            meetingDAO.update(m3);
            System.out.println("----------- Find All after update -----------");
            System.out.println(meetingDAO.findAll());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Meetings application");
        // checkMeetingInitial();
        showMeetings();
    }
}
