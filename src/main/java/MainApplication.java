import entities.Author;
import entities.Book;
import services.AuthorService;
import services.BookService;

import java.util.ArrayList;

public class MainApplication {

    public static void main(String[] args) {
        BookService bookService = new BookService();
        AuthorService authorService = new AuthorService();

        Book goblet = new Book("Harry Potter and the Goblet of Fire", "Fantasy",
                authorService.readById(3L), 2000, 13, "0-7475-4624-X");
        Book prince = new Book("Harry Potter and the Half Blood Prince", "Fantasy",
                authorService.readById(3L), 2005, 15, "0-7475-8108-8");

        // found out all entries I put into mysql were wiped out :'(
        // bookService.create(goblet); - entry confirmed created, but with id of 2?
        // bookService.readById(2)
        // bookService.create(prince);

        // authorService.deleteById(5L); - removed duplicated entry for rowling
        //bookService.deleteById(4);
        // System.out.println(bookService.readAll());
        System.out.println(authorService.readAll());
    }
}
