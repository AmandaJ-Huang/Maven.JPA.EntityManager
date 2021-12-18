package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface Services<T> {

    @PersistenceContext
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myEntityMgr");
    EntityManager em = emf.createEntityManager();

    void create(T data);
    T readById(Long id);
    List<T> readAll();
    void update(Long id, T newData);
    void deleteById(Long id);
}
