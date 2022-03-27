package com.example.lab5.Controllers;

import com.example.lab5.CustomExceptions.MissingPasswordException;
import com.example.lab5.CustomExceptions.MissingUsernameException;
import com.example.lab5.DBModels.User;
import com.example.lab5.DTOModels.UserDTO;
import com.example.lab5.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody UserDTO newUser){
        if(newUser.getUsername() == null)
            throw new MissingUsernameException("Username is required", HttpStatus.BAD_REQUEST.value());
        if(newUser.getPassword() == null)
            throw new MissingPasswordException("Password is required", HttpStatus.BAD_REQUEST.value());
        return userService.addUser(newUser);
    }

    @GetMapping("/get/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
