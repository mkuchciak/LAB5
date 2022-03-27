package com.example.lab5.Services;

import com.example.lab5.DBModels.Author;
import com.example.lab5.DBModels.Book;
import com.example.lab5.DTOModels.AuthorDTO;
import com.example.lab5.Repositories.AuthorDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService{
    private final AuthorDao authorDao;

    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Author save(AuthorDTO authorDTO) {
        var newAuthor = new Author();
        newAuthor.setName(authorDTO.getName());
        newAuthor.setSurname(authorDTO.getSurname());
        return authorDao.save(newAuthor);
    }

    @Override
    public List<Author> findByNameAndSurname(String name, String surname) {
        return authorDao.findAuthorsByNameAndSurname(name, surname);
    }

    @Override
    public List<Author> findAll() {
        var authorsList = new ArrayList<Author>();
        authorDao.findAll().iterator().forEachRemaining(authorsList::add);
        return authorsList;
    }

    @Override
    public Author deleteAuthor(long id) {
        var author = authorDao.findAuthorById(id);
        if(author != null)
            authorDao.delete(author);
        return author;
    }

    @Override
    public Author editAuthor(long authorId, AuthorDTO authorDTO) {
        var author = authorDao.findAuthorById(authorId);
        if(author == null)
            return null;
        if(authorDTO.getName() != null)
            author.setName(authorDTO.getName());
        if(authorDTO.getSurname() != null)
            author.setSurname(author.getSurname());
        return authorDao.save(author);
    }

    @Override
    public Author findById(long id) {
        return authorDao.findAuthorById(id);
    }

    @Override
    public List<Author> findAuthorsBySurname(String surname) {
        return authorDao.findAuthorsBySurname(surname);
    }

    @Override
    public Set<Book> getAuthorsBook(long id) {
        var author = authorDao.findAuthorById(id);
        if(author != null)
            return author.getBooks();
        return null;
    }
}
