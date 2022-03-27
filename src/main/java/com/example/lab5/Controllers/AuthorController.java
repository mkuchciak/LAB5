package com.example.lab5.Controllers;

import com.example.lab5.CustomExceptions.AuthorNotFoundException;
import com.example.lab5.CustomExceptions.MissingNameException;
import com.example.lab5.CustomExceptions.MissingSurnameException;
import com.example.lab5.DBModels.Author;
import com.example.lab5.DBModels.Book;
import com.example.lab5.DTOModels.AuthorDTO;
import com.example.lab5.Repositories.AuthorDao;
import com.example.lab5.Services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/add")
    public ResponseEntity<Author> saveAuthor(@RequestBody AuthorDTO authorDTO){
       if(authorDTO.getName() == null || authorDTO.getName().length() == 0)
           throw new MissingNameException("Name is mandatory field", HttpStatus.BAD_REQUEST.value());
        if(authorDTO.getSurname() == null || authorDTO.getSurname().length() == 0)
            throw new MissingSurnameException("Surname is mandatory field", HttpStatus.BAD_REQUEST.value());
       return new ResponseEntity<>(authorService.save(authorDTO), HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Author> findById(@PathVariable long id){
        var author = authorService.findById(id);
        if(author  == null)
            throw new AuthorNotFoundException("Author has not been found", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(author,HttpStatus.OK);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Author> editAuthor(@PathVariable long id, @RequestBody AuthorDTO author){
        if(author.getName() == null || author.getName().length() == 0)
            throw new MissingNameException("Name is mandatory field", HttpStatus.BAD_REQUEST.value());
        if(author.getSurname() == null || author.getSurname().length() == 0)
            throw new MissingSurnameException("Surname is mandatory field", HttpStatus.BAD_REQUEST.value());
        var editedAuthor = authorService.editAuthor(id, author);
        if(editedAuthor == null)
            throw new AuthorNotFoundException("Author has not been found", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(editedAuthor, HttpStatus.OK);
    }
    @PostMapping("/get/{name}/{surname}")
    public ResponseEntity<List<Author>> findByNameAndSurname(@PathVariable String name, @PathVariable String surname){
        return new ResponseEntity<>(authorService.findByNameAndSurname(name, surname), HttpStatus.OK);
    }
    @GetMapping("/get/surname/{surname}")
    public ResponseEntity<List<Author>> findBySurname(@PathVariable String surname){
        return new ResponseEntity<>(authorService.findAuthorsBySurname(surname), HttpStatus.OK);
    }
    @GetMapping("/get/all")
    public ResponseEntity<List<Author>> getAll(){
        return new ResponseEntity<>(authorService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<List<Book>> getAuthorsBooks(@PathVariable long id){
        var booksSet = authorService.getAuthorsBook(id);
        if(booksSet == null)
            throw new AuthorNotFoundException("Author has not been found", HttpStatus.NOT_FOUND.value());
        var booksList = new ArrayList<Book>();
        booksSet.iterator().forEachRemaining(booksList::add);
        return new ResponseEntity<>(booksList, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable long id){
        var deletedAuthor = authorService.deleteAuthor(id);
        if(deletedAuthor == null)
            throw new AuthorNotFoundException("Author has not been found", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(deletedAuthor, HttpStatus.OK);
    }
}
