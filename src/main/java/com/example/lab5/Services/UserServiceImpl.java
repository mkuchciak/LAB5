package com.example.lab5.Services;

import com.example.lab5.DBModels.Role;
import com.example.lab5.DBModels.User;
import com.example.lab5.DTOModels.UserDTO;
import com.example.lab5.Repositories.UserDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(value = "userService")
public class UserServiceImpl implements UserService{

    private UserDao userDao;


    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;

    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User findUserById(long id) {
        return userDao.findUserById(id);
    }

    @Override
    public User addUser(UserDTO userDTO) {
        var newUser = new User();
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(userDTO.getPassword());


        return userDao.save(newUser);
    }

    @Override
    public List<Role> changeUserRoles(long id) {
        return null;
    }

    @Override
    public User editUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        var usersList = new ArrayList<User>();
        userDao.findAll().iterator().forEachRemaining(usersList::add);
        return usersList;
    }

}
