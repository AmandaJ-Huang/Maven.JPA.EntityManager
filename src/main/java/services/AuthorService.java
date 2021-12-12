package services;

import entities.Author;
import entities.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    private AuthorRepository authorRepo;

    @Autowired
    public AuthorService(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    public Author create(Author author) {
        return authorRepo.save(author);
    }

    public Author readByID(Long id) {
        return authorRepo.findById(id).get();
    }

    public List<Author> readAll() {
        Iterable<Author> allAuthors = authorRepo.findAll();
        List<Author> authorList = new ArrayList<>();
        allAuthors.forEach(authorList::add);
        return authorList;
    }

    public Author update(Long id, Author newAuthorData) {
        Author authorInDatabase = this.readByID(id);
        authorInDatabase.setFirst_Name(newAuthorData.getFirst_Name());
        authorInDatabase.setLast_Name(newAuthorData.getLast_Name());
        authorInDatabase.setPublications(newAuthorData.getPublications());
        authorInDatabase = authorRepo.save(authorInDatabase);
        return authorInDatabase;
    }

    public Author deleteById(Long id) {
        Author authorToBeDeleted = this.readByID(id);
        authorRepo.delete(authorToBeDeleted);
        return authorToBeDeleted;
    }
}
