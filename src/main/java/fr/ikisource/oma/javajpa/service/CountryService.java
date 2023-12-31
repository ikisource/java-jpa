package fr.ikisource.oma.javajpa.service;

import fr.ikisource.oma.javajpa.model.Country;

public interface CountryService {

    Country create(Country country);

    void delete(String name);
}
