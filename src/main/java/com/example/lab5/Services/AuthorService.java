package com.example.lab5.Services;

import com.example.lab5.DBModels.Author;
import com.example.lab5.DBModels.Book;
import com.example.lab5.DTOModels.AuthorDTO;

import java.util.List;
import java.util.Set;

public interface AuthorService {
    Author save(AuthorDTO authorDTO);
    List<Author> findByNameAndSurname(String name, String surname);
    List<Author> findAll();
    Author deleteAuthor(long id);
    Author editAuthor(long id, AuthorDTO authorDTO);
    Author findById(long id);
    List<Author> findAuthorsBySurname(String surname);
    Set<Book> getAuthorsBook(long id);
}
