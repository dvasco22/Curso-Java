package local.repositories;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import local.connections.EntityManagerProvider;

public abstract class AbstractDAO<E> implements DAO<E> {

    EntityManager entityManager;
    Class<E> entityClass;

    public AbstractDAO(Class<E> entityClass) {
        entityManager = EntityManagerProvider.getEntityManager();
        this.entityClass = entityClass;
    }

    public AbstractDAO(
            Class<E> entityClass,
            EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }

    @Override
    public List<E> findAll() {

        String finalSQL = " FROM " + entityClass.getCanonicalName();
        // Query q = entityManager.createQuery(finalSQL, entityClass);
        // return (List<E>) q.getResultList();
        return entityManager
                .createQuery(finalSQL, entityClass)
                .getResultList();
    }

    @Override
    public <ID> Optional<E> findById(ID id) {
        // String finalSQL = " FROM " + entityClass.getCanonicalName()
        // + " WHERE id = " + id;
        return Optional.ofNullable(entityManager.find(entityClass, id));

    }

    @Override
    public E save(E entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity; // Return the saved entity
    }

    @Override
    public void update(E entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();

    }

    @Override
    public void delete(E entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    public void detach(E entity) {
        entityManager.detach(entity);
    }
}
