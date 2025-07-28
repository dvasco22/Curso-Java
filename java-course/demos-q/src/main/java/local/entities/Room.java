package local.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room implements IEntities {
    @Column(name = "room_id")
    @Id
    private String id;
    @Column(unique = true)
    private String name;
    private int capacity;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Meeting> meetings;

    public Room() {
        // JPA default constructor
        meetings = new HashSet<>();
    }

    public Room(String id, String name, int capacity) {
        this();
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
    }


    @Override
    public String toString() {
        return toString(false);
    }

    public String toString(boolean includeRelations) {
        StringBuilder sb = new StringBuilder();
        sb.append("Room {id:").append(id).append(", name:").append(name).append(", capacity:").append(capacity);

        if (includeRelations && meetings != null) {
            sb.append(", meetings:").append(meetings);
        }
        sb.append("}");
        return sb.toString();
    }

}
