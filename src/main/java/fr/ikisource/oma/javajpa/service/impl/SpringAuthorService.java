package fr.ikisource.oma.javajpa.service.impl;

import fr.ikisource.oma.javajpa.model.Author;
import fr.ikisource.oma.javajpa.model.Country;
import fr.ikisource.oma.javajpa.repository.AuthorRepository;
import fr.ikisource.oma.javajpa.repository.CountryRepository;
import fr.ikisource.oma.javajpa.service.AuthorService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class SpringAuthorService implements AuthorService {

    private AuthorRepository authorRepository;
    private CountryRepository countryRepository;

    public SpringAuthorService(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Author create(Author author) {

        Optional<Country> country = countryRepository.findById(author.getCountry().getName());
        if (country.isPresent()) {
            author.setCountry(country.get());
        }
        return authorRepository.save(author);
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
