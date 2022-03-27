package com.example.lab5.DBModels;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String title;
    private int pages;
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Author author;
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Rental> rentalsList;
}
