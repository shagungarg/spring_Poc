package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;
    private String publisher;

    @ManyToMany()
    @JoinTable(name="author_books",joinColumns = @JoinColumn(name = "book_id"),inverseJoinColumns = @JoinColumn(name="author_id"))
    private Set<Author> authors;

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(getId(), book.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public Book(Long id, String title, String isbn, String publisher, Set<Author> authors) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;

    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }


}
