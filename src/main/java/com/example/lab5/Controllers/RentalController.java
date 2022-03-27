package com.example.lab5.Controllers;

import com.example.lab5.CustomExceptions.*;
import com.example.lab5.DBModels.Rental;
import com.example.lab5.DTOModels.DateDTO;
import com.example.lab5.DTOModels.RentalDTO;
import com.example.lab5.Services.RentalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RelationNotFoundException;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping("/add")
    public ResponseEntity<Rental> addNewRental(@RequestBody RentalDTO rentalDTO){
        if(rentalDTO.getReturnDate() == null)
            throw new ReturnDateMissingException("Return Date is required", HttpStatus.BAD_REQUEST.value());
        if(rentalDTO.getReturnDate().before(Date.from(Instant.now())))
            throw new RentalInvalidDateException("Return Date must be after rent date", HttpStatus.BAD_REQUEST.value());
        var rental = rentalService.addRental(rentalDTO);
        if(rental.getUser() == null)
            throw new UserNotFoundException("User has not been found", HttpStatus.NOT_FOUND.value());
        if(rental.getBook() == null)
            throw new BookNotFoundException("Book has not been found", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(rental, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}/date")
    public ResponseEntity<Rental> editReturnDate(@PathVariable long id, @RequestBody DateDTO dateDTO){
       if(dateDTO.getDate() == null)
           throw new ReturnDateMissingException("Return Date is required", HttpStatus.BAD_REQUEST.value());
        if(dateDTO.getDate().before(Date.from(Instant.now())))
           throw new RentalInvalidDateException("Return Date must be after rent date", HttpStatus.BAD_REQUEST.value());
       var rental = rentalService.editReturnDate(id, dateDTO.getDate());
       if(rental == null)
           throw new RentalNotFoundException("Rental has not been found", HttpStatus.NOT_FOUND.value());

       return new ResponseEntity<>(rental, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Rental> deleteRental(@PathVariable long id){
        var deletedRental = rentalService.removeRental(id);
        if(deletedRental == null)
            throw new RentalNotFoundException("Rental has not been found", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(deletedRental, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Rental> getRentalById(@PathVariable long id){
       var rental = rentalService.getRental(id);
       if(rental == null)
           throw new RentalNotFoundException("Rental has not been found", HttpStatus.NOT_FOUND.value());
       return new ResponseEntity<>(rental, HttpStatus.OK);
    }

    @GetMapping("/get/user/{id}")
    public ResponseEntity<List<Rental>> getUsersRental(@PathVariable long id){
        var rentalList = rentalService.getUsersRental(id);
        if(rentalList == null)
            throw new UserNotFoundException("User has not been found", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(rentalList, HttpStatus.OK);
    }
    @GetMapping("/get/book/{id}")
    public ResponseEntity<List<Rental>> getBookRental(@PathVariable long id){
        var rentalList = rentalService.getBooksRental(id);
        if(rentalList == null)
            throw new BookNotFoundException("Book has not been found", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(rentalList, HttpStatus.OK);
    }
}
