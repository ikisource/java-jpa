package fr.ikisource.oma.javajpa.service.impl;

import fr.ikisource.oma.javajpa.model.Country;
import fr.ikisource.oma.javajpa.repository.CountryRepository;
import fr.ikisource.oma.javajpa.service.CountryService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SpringCountryService implements CountryService {

    private CountryRepository countryRepository;

    public SpringCountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country create(Country country) {

        return countryRepository.save(country);
    }

    @Override
    public void delete(String name) {

        countryRepository.deleteById(name);
    }
}
