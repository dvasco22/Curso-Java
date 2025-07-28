package local.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "persons")
public class Person implements IEntities {
    @Column(name = "person_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String email;

    // Primera tabla de la relación
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //
    @JoinTable(
            // name = "persons_meetings",
            joinColumns = {
                 @JoinColumn(name = "meeting_id") },
            inverseJoinColumns = {
                    @JoinColumn(name = "person_id") })
    private Set<Meeting> meetings;

    public Person() {
        // JPA default constructor
        meetings = new HashSet<>();
    }

    public Person(String name, String surname, String email) {
        this();
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    // Getters

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Meeting> getMeetings() {
        return meetings;
    }

    // Setters

    public void addMeeting(Meeting meeting) {
        if (meeting == null) {
            throw new IllegalArgumentException("Meeting cannot be null");
        }
        if (meetings.contains(meeting)) {
            return; // Meeting already added
        }
        this.meetings.add(meeting);
        // Ensure bidirectional relationship
        // Al ser un Set, no se añade si ya existe
        // pero podría entrar en un bucle infinito si no se comprueba
        if (!meeting.getPersons().contains(this)) {
            meeting.getPersons().add(this);
        }
    }

    @Override
    public String toString() {
        return toString(false);
    }

    public String toString(boolean isFull) {
        StringBuilder sb = new StringBuilder();
        sb.append("Person {id: ").append(id)
                //
                .append(", name: ").append(name)
                //
                .append(", surname: ").append(surname)
                //
                .append(", email: ").append(email);
        if (isFull && meetings != null) {
            sb.append(", meetings: ").append(meetings);
        }
        sb.append("}");
        return sb.toString();
    }

}
