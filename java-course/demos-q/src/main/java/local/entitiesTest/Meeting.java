
package local.entitiesTest;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="meetings")
public class Meeting {
    @Column(name = "meeting_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 

    private String description;
    private LocalDateTime date;

    public Meeting() {
        // JPA default constructor
    }

    public Meeting( String description, LocalDateTime date) {
        this.description = description;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Meeting [id=" + id + ", description=" + description + ", date=" + date + "]";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}