package fr.ikisource.oma.javajpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Country {

    @Id
    @Column
    private String name;

    @OneToMany
    private List<Author> authors;

    public Country(String name) {
        this.name = name;
    }

    public Country() {

    }

    public String getName() {
        return name;
    }
}
