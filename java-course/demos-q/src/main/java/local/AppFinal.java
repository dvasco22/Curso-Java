package local;

import java.time.LocalDateTime;

import local.entities.Meeting;
import local.entities.Person;
import local.entities.Room;
import local.entities.Record;
import local.repositories.MeetingDAO;
import local.repositories.PersonDAO;

public class AppFinal {

    static PersonDAO personDAO = new PersonDAO();
    static MeetingDAO meetingDAO = new MeetingDAO();


    public static void main(String[] args) {

        Meeting m  = new Meeting("Reunion inicial del proyecto",LocalDateTime.now().plusDays(1));
        Room r = new Room("S0103", "Sala DeLuxe", 12);
        m.setRoom(r);
        Person p1 = new Person("Ernestina", "Ramírez", "erni@sample.com");
        Person p2 = personDAO.findById(3).get();
        m.addParticipant(p1);
        m.addParticipant(p2);
        Record rc = new Record("Lo que haremos en el preoyecto nuevo");
        m.setRecord(rc);
        m = meetingDAO.save(m);

        AppMeetings.showOptional(meetingDAO.findById(m.getId()), "Meeting");

    }

}
