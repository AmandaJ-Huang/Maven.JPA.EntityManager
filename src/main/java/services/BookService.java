package services;

import entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements Services<Book> {

    public void create(Book book) {
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
    }

    public Book readById(Long id) {
        return em.find(Book.class, id);
    }

    public List<Book> readAll() {
        return em.createQuery("SELECT * FROM book", Book.class)
                .getResultList();
    }

    public void update(Long id, Book newBookData) {
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

    public void deleteById(Long id) {
        em.getTransaction().begin();
        Book book = em.find(Book.class, id);
        em.remove(book);
        em.getTransaction().commit();
        System.out.println(book.toString() + " has been removed.");
    }

}
