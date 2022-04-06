package com.example.lab5.Controllers;

import com.example.lab5.CustomExceptions.AuthorNotFoundException;
import com.example.lab5.CustomExceptions.BookNotFoundException;
import com.example.lab5.CustomExceptions.MissingTitleException;
import com.example.lab5.DBModels.Book;
import com.example.lab5.DTOModels.BookDTO;
import com.example.lab5.Services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins ="*", allowedHeaders = "*")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addNewBook(@RequestBody BookDTO bookDTO){
        var newBook = bookService.saveBook(bookDTO);
        if(newBook.getId() == -2){
            throw new MissingTitleException("Title is required", HttpStatus.BAD_REQUEST.value());
        }
        if(newBook.getId() == -1){
            throw new AuthorNotFoundException("Author could not be found", HttpStatus.NOT_FOUND.value());
        }

        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> editBook(@RequestBody BookDTO bookDTO, @PathVariable long id){
        var editedBook = bookService.editBook(bookDTO, id);
        if(editedBook.getId() == -1){
            throw new AuthorNotFoundException("Author could not be found", HttpStatus.NOT_FOUND.value());
        }
        return new ResponseEntity<>(editedBook, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable long id){
        var deletedBook = bookService.deleteBook(id);
        if(deletedBook == null)
            throw new BookNotFoundException("Book has not been found", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(deletedBook, HttpStatus.OK);
    }

    @GetMapping("/search/title/{title}")
    public ResponseEntity<List<Book>> searchBooksByTitle(@PathVariable String title){
        return new ResponseEntity<>(bookService.getBooksByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/search/id/{id}")
    public ResponseEntity<Book> searchBookById(@PathVariable long id){
        var book = bookService.getBookById(id);
        if(book == null){
            throw new BookNotFoundException("Book has not been found", HttpStatus.NOT_FOUND.value());
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/search/author/{id}")
    public ResponseEntity<List<Book>> searchBooksByTitle(@PathVariable long id){
        return new ResponseEntity<>(bookService.getBooksByAuthor(id), HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }
}
