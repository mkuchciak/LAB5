package com.example.lab5.DTOModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorDTO {
    private Long id;
    private String name;
    private String surname;
}
