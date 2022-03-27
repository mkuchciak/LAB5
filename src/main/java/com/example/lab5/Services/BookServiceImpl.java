package com.example.lab5.Services;

import com.example.lab5.DBModels.Book;
import com.example.lab5.DTOModels.BookDTO;
import com.example.lab5.Repositories.AuthorDao;
import com.example.lab5.Repositories.BookDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;
    private final AuthorDao authorDao;

    public BookServiceImpl(BookDao bookDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }

    @Override
    public Book saveBook(BookDTO bookDTO) {
        var newBook = new Book();
        if(bookDTO.getTitle() == null){
            newBook.setId(-2);
            return newBook;
        }

        newBook.setTitle(bookDTO.getTitle());
        newBook.setPages(bookDTO.getPages());
        if(bookDTO.getAuthor() != null){
            var author = authorDao.findAuthorById(bookDTO.getAuthor());
            if(author != null){
                newBook.setAuthor(author);
            }
            else {
                newBook.setId(-1);
                return newBook;
            }
        }
        return bookDao.save(newBook);
    }

    @Override
    public Book editBook(BookDTO bookDTO) {
        var book = bookDao.findBookById(bookDTO.getId());
        if(bookDTO.getTitle() != null)
            book.setTitle(bookDTO.getTitle());
        if(bookDTO.getPages() != null)
            book.setPages(bookDTO.getPages());
        if(bookDTO.getAuthor() != null){
            var author = authorDao.findAuthorById(bookDTO.getAuthor());
            if(author != null){
                book.setAuthor(author);
            }
            else{
                var tempBook = new Book();
                tempBook.setId(-1);
                return tempBook;
            }
        }

        return bookDao.save(book);
    }

    @Override
    public Book deleteBook(long id) {
        var book = bookDao.findBookById(id);
        if(book == null)
            return null;
        bookDao.delete(book);
        return book;
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return bookDao.findBooksByTitle(title);
    }

    @Override
    public List<Book> getBooksByAuthor(long authorId) {
        var author = authorDao.findAuthorById(authorId);
        if(author == null)
            return null;
        else
            return bookDao.findBooksByAuthor(author);
    }

    @Override
    public Book getBookById(long id) {
        return bookDao.findBookById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        var bookList = new ArrayList<Book>();
        bookDao.findAll().iterator().forEachRemaining(bookList::add);
        return bookList;
    }
}
