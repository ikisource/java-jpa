package fr.ikisource.oma.javajpa.service.impl;

import fr.ikisource.oma.javajpa.model.Country;
import fr.ikisource.oma.javajpa.repository.CountryRepository;
import fr.ikisource.oma.javajpa.service.CountryService;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Transactional
public class SpringCountryService implements CountryService {

    private CountryRepository countryRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public SpringCountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country create(Country country) {

        return countryRepository.save(country);
    }

    @Override
    public Country get(String id) {

        return countryRepository.getReferenceById(id);
    }

    @Override
    public Country getWithAuthorsUsingGetter(String id) {

        Country country = countryRepository.getReferenceById(id);
        country.getAuthors().size();

        return country;
    }

    @Override
    public Country getWithAuthorsUsingHibernateInitialize(String id) {

        Country country = countryRepository.getReferenceById(id);
        Hibernate.initialize(country.getAuthors());

        return country;
    }

    @Override
    public Country getWithAuthorsUsingNamedEntityGraph(String id) {

        EntityGraph<?> entityGraph = entityManager.getEntityGraph("authors");
        return entityManager.find(Country.class, id, Map.of("javax.persistence.fetchgraph", entityGraph));
    }

    @Override
    public Country getWithAuthorsUsingEntityGraphProgrammatically(String id) {

        EntityGraph<Country> entityGraph = entityManager.createEntityGraph(Country.class);
        entityGraph.addAttributeNodes("authors");
        return entityManager.find(Country.class, id, Map.of("javax.persistence.fetchgraph", entityGraph));
    }

    @Override
    public void delete(String name) {

        countryRepository.deleteById(name);
    }
}
