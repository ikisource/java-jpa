package fr.ikisource.oma.javajpa.service;

import fr.ikisource.oma.javajpa.model.Author;
import fr.ikisource.oma.javajpa.model.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CountryServiceTest {

    @Autowired
    private CountryService countryService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private DataManager dm;

    @BeforeEach
    public void executedBeforeEachTest() {
        dm.cleanDatabase();
    }

    @Test
    public void create() {

        Country country = new Country("France");

        Country created = countryService.create(country);

        Assertions.assertNotNull(created.getName());
    }

    @Test
    public void get() {

        Author author = dm.createAuthor();

        Country entity = countryService.get(author.getCountry().getName());
        Assertions.assertNotNull(entity);
    }

    @Test
    public void getWithAuthorsUsingGetter() {

        Author author = dm.createAuthor();
        Country entity = countryService.getWithAuthorsUsingGetter(author.getCountry().getName());

        Assertions.assertEquals(1, entity.getAuthors().size());
        Assertions.assertNotNull(entity);
    }

    @Test
    public void getWithAuthorsUsingHibernateInitialize() {

        Author author = dm.createAuthor();
        Country entity = countryService.getWithAuthorsUsingHibernateInitialize(author.getCountry().getName());

        Assertions.assertEquals(1, entity.getAuthors().size());
        Assertions.assertNotNull(entity);
    }

    @Test
    public void getWithAuthorsUsingNamedEntityGraph() {

        Author author = dm.createAuthor();
        Country entity = countryService.getWithAuthorsUsingNamedEntityGraph(author.getCountry().getName());

        Assertions.assertEquals(1, entity.getAuthors().size());
        Assertions.assertNotNull(entity);
    }

    @Test
    public void getWithAuthorsUsingEntityGraphProgrammatically() {

        Author author = dm.createAuthor();
        Country entity = countryService.getWithAuthorsUsingEntityGraphProgrammatically(author.getCountry().getName());

        Assertions.assertEquals(1, entity.getAuthors().size());
        Assertions.assertNotNull(entity);
    }

    @Test
    public void get_null() {

        Assertions.assertThrows(Exception.class, () -> {
            countryService.get(null);
        });
    }

    @Test
    public void delete() {

        Country country = dm.createCountry();
        Assertions.assertEquals(1, dm.countryRepository.count());

        countryService.delete(country.getName());
        Assertions.assertEquals(0, dm.countryRepository.count());
    }

    @Test
    public void delete_with_authors() {

        Country country = dm.createCountry();
        Assertions.assertEquals(1, dm.countryRepository.count());

        Author author = new Author(country, "Werber");
        Author createdAuthor = authorService.create(author);

        Assertions.assertThrows(Exception.class, () -> {
            countryService.delete(country.getName()); // delete not possible because an author is using this country
        });
    }
}
