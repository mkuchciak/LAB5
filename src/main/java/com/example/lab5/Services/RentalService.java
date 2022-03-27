package com.example.lab5.Services;

import com.example.lab5.DBModels.Rental;
import com.example.lab5.DTOModels.RentalDTO;

import java.util.Date;
import java.util.List;

public interface RentalService {
    Rental addRental(RentalDTO rentalDTO);
    Rental editReturnDate(long id, Date returnDate);
    Rental removeRental(long id);
    Rental getRental(long id);
    List<Rental> getUsersRental(long userId);
    List<Rental> getBooksRental(long bookId);
}
