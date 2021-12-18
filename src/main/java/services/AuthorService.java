package services;

import entities.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements Services<Author> {

    public void create(Author author) {
        em.getTransaction().begin();
        em.persist(author);
        em.getTransaction().commit();
    }

    public Author readById(Long id) {
        return em.find(Author.class, id);
    }

    public List<Author> readAll() {
        return em.createQuery("SELECT * FROM author", Author.class)
                .getResultList();
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
