package entities;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

        @Id
        @GeneratedValue
        private Long id;

        private String title;
        private String genre;

        @OneToOne
        private Author author;

        private Integer year;
        private Integer price;
        private String isbn;

        public Book() {
        }

        public Book(String title, String genre, Author author,
                Integer year, Integer price, String isbn) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.year = year;
        this.price = price;
        this.isbn = isbn;
        }

        public Book(Long id, String title, String genre, Author author,
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

        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
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
