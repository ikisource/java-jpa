package fr.ikisource.oma.javajpa.model;

import jakarta.persistence.*;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST) // creates the country when the author is created
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_author_country"), name = "country_id", nullable = false)
    private Country country;

    @Column
    private String name;

    public Author(Country country, String name) {
        this.country = country;
        this.name = name;
    }

    public Author() {

    }

    public Country getCountry() {
        return country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
