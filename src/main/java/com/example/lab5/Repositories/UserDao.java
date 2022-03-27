package com.example.lab5.Repositories;

import com.example.lab5.DBModels.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User findUserById(long id);
    User findByUsername(String username);
}
