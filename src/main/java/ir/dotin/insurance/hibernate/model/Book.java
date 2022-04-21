package ir.dotin.insurance.hibernate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne(optional = false)
    private Author author;

    public Book(String name, Author author) {
        this.name = name;
        this.author = author;
    }
}
