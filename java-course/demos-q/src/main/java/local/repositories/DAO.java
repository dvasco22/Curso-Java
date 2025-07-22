

package local.repositories;

import java.util.List;
import java.util.Optional;

public interface DAO<E> {
    List<E> findAll();
    <ID> Optional<E> findById(ID id);
    E save(E entity);
    void update(E entity);
    void delete(E entity);
    // <ID> void delete(ID id);
}
