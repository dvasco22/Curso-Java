package local.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "records")
public class Record implements IEntities {
    @Column(name = "record_id")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String content;

    @OneToOne
    @JoinColumn(name = "meeting_id", unique = true)
    private Meeting meeting;

    public Record(String content) {
        this.content = content;
    }

    public Record() {
        // JPA default constructor
    }

    public UUID getId() {
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return toString(false);
    }

    public String toString(boolean isFull) {
        StringBuilder sb = new StringBuilder();
        sb.append("Record {id:").append(id)
                //
                .append(", content:").append(content);

        if (isFull && meeting != null) {
            sb.append(", meeting: ").append(meeting);
        }
        sb.append("}");
        return sb.toString();
    }
}
