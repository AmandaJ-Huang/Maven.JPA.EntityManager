package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

        @Id
        private Long id;

        private String title;
        private String genre;
        private String author;
        private Integer year;
        private Integer price;
        private String isbn;

        public Book() {
        }

        public Book(String title, String genre, String author,
                Integer year, Integer price, String isbn) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.year = year;
        this.price = price;
        this.isbn = isbn;
        }

        public Book(Long id, String title, String genre, String author,
                    Integer year, Integer price, String isbn) {
            this.id = id;
            this.title = title;
            this.genre = genre;
            this.author = author;
            this.year = year;
            this.price = price;
            this.isbn = isbn;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public Integer getYear() {
            return year;
        }

        public void setYear(Integer year) {
            this.year = year;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        @Override
        public String toString() {
            return "book{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", genre='" + genre + '\'' +
                    ", author='" + author + '\'' +
                    ", year=" + year +
                    ", price=" + price +
                    ", isbn='" + isbn + '\'' +
                    '}';
        }
}
