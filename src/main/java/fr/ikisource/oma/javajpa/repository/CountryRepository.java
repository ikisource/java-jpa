package fr.ikisource.oma.javajpa.repository;

import fr.ikisource.oma.javajpa.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {

}
