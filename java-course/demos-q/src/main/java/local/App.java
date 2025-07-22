
package local;

import java.time.LocalDateTime;

import local.entities.Meeting;
import local.repositories.MeetingDAO;;

/**
 * Hello world!
 */
public final class App {
    private App() {

    }

    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        MeetingDAO meetingDAO = new MeetingDAO();

        meetingDAO.save(new Meeting(
                "Primera reunion", LocalDateTime.now().plusDays(2)));

        System.out.println(
                meetingDAO.findAll());

        System.out.println(
                meetingDAO.findById(1));

        System.out.println(
                meetingDAO.findById(100));

        try {
            meetingDAO.delete(
                    meetingDAO.findById(2).get());
        } catch (Exception e) {
            System.out.println("Meeting ya eliminado");
        }

        System.out.println(
                meetingDAO.findAll());

        System.out.println("___________________________________");
        Meeting m2 = meetingDAO.findById(1).get();
        m2.setDescription("Reunion modificada");

        meetingDAO.update(m2);

        System.out.println(
                meetingDAO.findAll());
    }
}