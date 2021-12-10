package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author {

    @Id
    private Long id;

    private String first_name;
    private String last_name;
    private Integer publications;

    public Author() {
    }

    public Author(String first_name, String last_name, Integer publications) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.publications = publications;
    }

    public Author(Long id, String first_name, String last_name, Integer publications) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.publications = publications;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getPublications() {
        return publications;
    }

    public void setPublications(Integer publications) {
        this.publications = publications;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", publications=" + publications +
                '}';
    }
}
