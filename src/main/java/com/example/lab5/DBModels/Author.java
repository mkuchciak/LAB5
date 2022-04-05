package com.example.lab5.DBModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public @Getter @Setter
class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @JsonIgnore
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Set<Book> books;
}
