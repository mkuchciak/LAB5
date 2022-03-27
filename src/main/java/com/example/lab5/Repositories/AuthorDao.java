package com.example.lab5.Repositories;

import com.example.lab5.DBModels.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorDao extends CrudRepository<Author, Long> {
    List<Author> findAuthorsByNameAndSurname(String name, String surname);
    Author findAuthorById(long id);
    List<Author> findAuthorsBySurname(String surname);
}
