package com.example.lab5.Services;

import com.example.lab5.DBModels.Rental;
import com.example.lab5.DTOModels.RentalDTO;
import com.example.lab5.Repositories.BookDao;
import com.example.lab5.Repositories.RentalDao;
import com.example.lab5.Repositories.UserDao;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class RentalServiceImpl implements RentalService{

    private final RentalDao rentalDao;
    private final BookDao bookDao;
    private final UserDao userDao;

    public RentalServiceImpl(RentalDao rentalDao, BookDao bookDao, UserDao userDao) {
        this.rentalDao = rentalDao;
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    @Override
    public Rental addRental(RentalDTO rentalDTO) {
        var newRental = new Rental();
        newRental.setRentedDate(Date.from(Instant.now()));
        newRental.setReturnDate(rentalDTO.getReturnDate());
        var rentedBook = bookDao.findBookById(rentalDTO.getBookId());
        var user = userDao.findUserById(rentalDTO.getUserId());
        if(rentedBook != null){
            newRental.setBook(rentedBook);
        }else{
            newRental.setBook(null);
            return newRental;
        }
        if(user != null){
            newRental.setUser(user);
        }else{
            newRental.setBook(null);
            return newRental;
        }
        return rentalDao.save(newRental);
    }

    @Override
    public Rental editReturnDate(long id, Date returnDate) {
        var rental = rentalDao.findRentalById(id);
        if(rental == null)
            return null;
        if(returnDate == null || returnDate.before(rental.getRentedDate()) || returnDate.before(Date.from(Instant.now())))
            return null;
        rental.setReturnDate(returnDate);
        return rentalDao.save(rental);
    }

    @Override
    public Rental removeRental(long id) {
        var rental = rentalDao.findRentalById(id);
        if(rental == null)
            return null;
        rentalDao.delete(rental);
        return rental;
    }

    @Override
    public Rental getRental(long id) {
        return rentalDao.findRentalById(id);
    }

    @Override
    public List<Rental> getUsersRental(long userId) {
        var user = userDao.findUserById(userId);
        if(user == null)
            return null;
        return rentalDao.findRentalsByUser(user);
    }

    @Override
    public List<Rental> getBooksRental(long bookId) {
        var book = bookDao.findBookById(bookId);
        if(book == null)
            return null;
        return rentalDao.findRentalsByBook(book);
    }
}
