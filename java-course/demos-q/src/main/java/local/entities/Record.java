package local.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "records")
public class Record {
    @Column(name = "record_id")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String content;

    public Record(String content) {
        this.content = content;
    }

    public Record() {
        // JPA default constructor
    }

    @Override
    public String toString() {
        return "Record [id=" + id + ", content=" + content + "]";
    }


}
