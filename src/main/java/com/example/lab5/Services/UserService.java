package com.example.lab5.Services;

import com.example.lab5.DBModels.Role;
import com.example.lab5.DBModels.User;
import com.example.lab5.DTOModels.UserDTO;

import java.util.List;

public interface UserService {
    User findUserByUsername(String username);
    User findUserById(long id);
    User addUser(UserDTO userDTO);
    List<Role> changeUserRoles(long id);
    User editUser(UserDTO userDTO);
    List<User> getAllUsers();
}
