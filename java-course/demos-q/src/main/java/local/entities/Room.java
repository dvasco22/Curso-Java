package local.entities;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="rooms")
public class Room {
    @Column(name = "room_id")
    @Id
    private String id;
    @Column(unique = true)
    private String name;
    private int capacity;

    @OneToMany(mappedBy = "room",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY)
    private Set<Meeting> meetings;

    public Room() {
       // JPA default constructor
    }

    public Room(String id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Room [id=" + id + ", name=" + name + ", capacity=" + capacity + ", meetings=" + meetings + "]";
    }


}