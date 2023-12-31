package fr.ikisource.oma.javajpa.repository;

import fr.ikisource.oma.javajpa.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
