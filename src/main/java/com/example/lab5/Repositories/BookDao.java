package com.example.lab5.Repositories;

import com.example.lab5.DBModels.Author;
import com.example.lab5.DBModels.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao extends CrudRepository<Book, Long> {
    Book findBookById(long id);
    List<Book> findBooksByTitle(String title);
    List<Book> findBooksByAuthor(Author author);
}
