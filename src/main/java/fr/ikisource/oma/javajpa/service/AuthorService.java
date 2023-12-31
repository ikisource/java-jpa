package fr.ikisource.oma.javajpa.service;

import fr.ikisource.oma.javajpa.model.Author;

public interface AuthorService {

    Author create(Author author);

    void delete(Long id);
}
