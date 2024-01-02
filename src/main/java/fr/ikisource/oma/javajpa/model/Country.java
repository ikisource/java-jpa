package fr.ikisource.oma.javajpa.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@NamedEntityGraph(
        name = "authors",
        attributeNodes = {
                @NamedAttributeNode("authors")
        }
)
@Entity
public class Country {

    @Id
    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    private List<Author> authors = new ArrayList<>();

    public Country(String name) {
        this.name = name;
    }

    public Country() {
    }

    public String getName() {
        return name;
    }

    public List<Author> getAuthors() {
        return authors;
    }
}
