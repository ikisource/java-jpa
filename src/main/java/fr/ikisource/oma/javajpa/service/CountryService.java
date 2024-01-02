package fr.ikisource.oma.javajpa.service;

import fr.ikisource.oma.javajpa.model.Country;

public interface CountryService {

    Country create(Country country);

    /**
     * Get a country by its id
     * @param id - The identifier
     * @return The country
     */
    Country get(String id);

    /**
     * Get a country by its id
     * The list of authors attached to the country is also retrieved using a getter
     * @param id - The identifier
     * @return The country or null if not found
     */
    Country getWithAuthorsUsingGetter(String id);

    /**
     * Get a country by its id
     * The list of authors attached to the country is also retrieved using Hibernate.initialize()
     * @param id - The identifier
     * @return The country or null if not found
     */
    Country getWithAuthorsUsingHibernateInitialize(String id);

    /**
     * Get a country by its id
     * The list of authors attached to the country is also retrieved using NamedEntityGraph
     * @param id - The identifier
     * @return The country or null if not found
     */
    Country getWithAuthorsUsingNamedEntityGraph(String id);

    /**
     * Get a country by its id
     * The list of authors attached to the country is also retrieved using EntityGraph programmatically
     * @param id - The identifier
     * @return The country or null if not found
     */
    Country getWithAuthorsUsingEntityGraphProgrammatically(String id);

    void delete(String name);
}
