package services;

import entities.Book;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class BookService {

    @PersistenceUnit
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    @PersistenceContext
    EntityManager em = emf.createEntityManager();

    public void create(Book book) {
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
    }

    public Book readById(Integer id) {
        return em.find(Book.class, id);
    }

    public List<Book> readAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> cr = cb.createQuery(Book.class);
        Root<Book> root = cr.from(Book.class);
        CriteriaQuery<Book> selectAll = cr.select(root);
        TypedQuery<Book> selectAllQuery = em.createQuery(selectAll);

        return selectAllQuery.getResultList();
    }

    public void update(Integer id, Book newBookData) {
        Book bookInDatabase = em.find(Book.class, id);

        em.getTransaction().begin();
        bookInDatabase.setTitle(newBookData.getTitle());
        bookInDatabase.setGenre(newBookData.getGenre());
        bookInDatabase.setAuthor(newBookData.getAuthor());
        bookInDatabase.setYear(newBookData.getYear());
        bookInDatabase.setPrice(newBookData.getPrice());
        bookInDatabase.setIsbn(newBookData.getIsbn());

        em.getTransaction().commit();
    }

    public void deleteById(Integer id) {
        em.getTransaction().begin();
        Book book = em.find(Book.class, id);
        em.remove(book);
        em.getTransaction().commit();
        System.out.println(book.toString() + " has been removed.");
    }

}
