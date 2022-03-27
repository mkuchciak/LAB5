package com.example.lab5.Services;

import com.example.lab5.DBModels.Book;
import com.example.lab5.DTOModels.BookDTO;

import java.util.List;

public interface BookService {
    Book saveBook(BookDTO bookDTO);
    Book editBook(BookDTO bookDTO);
    Book deleteBook(long id);
    List<Book> getBooksByTitle(String title);
    List<Book> getBooksByAuthor(long authorId);
    Book getBookById(long id);
    List<Book> getAllBooks();

}
