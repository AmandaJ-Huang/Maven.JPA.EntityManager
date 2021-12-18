package services;

import javax.persistence.*;
import java.util.List;

public interface Services<T> {

    @PersistenceUnit
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    @PersistenceContext
    EntityManager em = emf.createEntityManager();

    void create(T data);
    T readById(Long id);
    List<T> readAll();
    void update(Long id, T newData);
    void deleteById(Long id);
}
