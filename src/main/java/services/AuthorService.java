package services;

import entities.Author;
import entities.Book;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class AuthorService {

    @PersistenceUnit
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    @PersistenceContext
    EntityManager em = emf.createEntityManager();

    public void create(Author author) {
        em.getTransaction().begin();
        em.persist(author);
        em.getTransaction().commit();
    }

    public Author readById(Long id) {
        return em.find(Author.class, id);
    }

    public List<Author> readAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Author> cr = cb.createQuery(Author.class);
        Root<Author> root = cr.from(Author.class);
        CriteriaQuery<Author> selectAll = cr.select(root);
        TypedQuery<Author> selectAllQuery = em.createQuery(selectAll);

        return selectAllQuery.getResultList();
    }

    public void update(Long id, Author newAuthorData) {
        Author authorInDatabase = em.find(Author.class, id);

        em.getTransaction().begin();
        authorInDatabase.setFirst_Name(newAuthorData.getFirst_Name());
        authorInDatabase.setLast_Name(newAuthorData.getLast_Name());
        em.getTransaction().commit();

    }

    public void deleteById(Long id) {
        em.getTransaction().begin();
        Author author = em.find(Author.class, id);
        em.remove(author);
        em.getTransaction().commit();
        System.out.println(author.toString() + " has been removed.");
    }
}
