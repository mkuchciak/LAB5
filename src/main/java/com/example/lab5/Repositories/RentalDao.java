package com.example.lab5.Repositories;

import com.example.lab5.DBModels.Book;
import com.example.lab5.DBModels.Rental;
import com.example.lab5.DBModels.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalDao extends CrudRepository<Rental, Long> {
    List<Rental> findRentalsByUser(User user);
    Rental findRentalById(long id);
    List<Rental> findRentalsByBook(Book book);
}
