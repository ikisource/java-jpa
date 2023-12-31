package fr.ikisource.oma.javajpa.service;

import fr.ikisource.oma.javajpa.model.Author;
import fr.ikisource.oma.javajpa.model.Country;
import fr.ikisource.oma.javajpa.repository.AuthorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthorServiceTest {

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
        Author author = new Author(country, "Werber");

        Author createdAuthor = authorService.create(author);

        Assertions.assertNotNull(createdAuthor.getId());
    }

    @Test
    public void delete() {

        Author author = dm.createAuthor(new Country("France"));

        Assertions.assertEquals(1, dm.authorRepository.count());

        authorService.delete(author.getId());

        Assertions.assertEquals(0, dm.authorRepository.count());
        // country is not deleted
        Assertions.assertEquals(1, dm.countryRepository.count());
    }
}
