package fr.ikisource.oma.javajpa.repository;

import fr.ikisource.oma.javajpa.model.Country;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, String> {

//    @EntityGraph(attributePaths = { "authors" })
    Optional<Country> findById(String id);

//    Optional<Country> findById(String id, EntityGraph entityGraph);
}
