package local.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.TypedQuery;
import local.entities.Meeting;

public class MeetingDAO extends AbstractDAO<Meeting> {

    public MeetingDAO() {
        super(Meeting.class);
    }

    public List<Meeting> findByDate(LocalDate date) {
        // String qs = "SELECT m FROM Meeting m WHERE m.date = ?1";
        String qs = "FROM Meeting m WHERE DATE(m.date) = ?1";
        // Query query = entityManager.createQuery(qs);
        TypedQuery<Meeting> query = entityManager.createQuery(qs, Meeting.class);
        query.setParameter(1, date);
        return query.getResultList();
    }

    public Optional<Meeting> nextMeetingBasic() {
        // Example method to find the next meeting
        // using a query to find the next meeting

        try {
               String qs = " FROM " + Meeting.class.getCanonicalName()
                + " WHERE date > :currentDate ORDER BY date ASC LIMIT 1";
            TypedQuery<Meeting> query = entityManager.createQuery(qs, Meeting.class);
            query.setParameter("currentDate", LocalDateTime.now());
            return Optional.ofNullable(query.getSingleResult());
        } catch (Exception e) {
            return Optional.empty();
        }


    };

}
