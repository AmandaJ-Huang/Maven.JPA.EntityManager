package services;

import entities.Author;
import entities.Book;
import entities.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepo;

    @PersistenceContext
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("books");
    private EntityManager em = emf.createEntityManager();

    @Autowired
    public BookService(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }


    public Book create(Book book) {
        return bookRepo.save(book);
    }

    public Book readByID(Long id) {
        return bookRepo.findById(id).get();
    }

    public List<Book> readAll() {
        Iterable<Book> allBooks = bookRepo.findAll();
        List<Book> bookList = new ArrayList<>();
        allBooks.forEach(bookList::add);
        return bookList;
    }

    public Book update(Long id, Book newBookData) {
        Book bookInDatabase = this.readByID(id);
        bookInDatabase.setTitle(newBookData.getTitle());
        bookInDatabase.setGenre(newBookData.getGenre());
        bookInDatabase.setAuthor(newBookData.getAuthor());
        bookInDatabase.setYear(newBookData.getYear());
        bookInDatabase.setPrice(newBookData.getPrice());
        bookInDatabase.setIsbn(newBookData.getIsbn());
        bookInDatabase = bookRepo.save(bookInDatabase);
        return bookInDatabase;
    }

    public Book deleteById(Long id) {
        Book bookToBeDeleted = this.readByID(id);
        bookRepo.delete(bookToBeDeleted);
        return bookToBeDeleted;
    }

}
