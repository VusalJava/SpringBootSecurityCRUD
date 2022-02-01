package com.example.springbootcrud.service;

import com.example.springbootcrud.domain.User;
import java.util.List;

public interface UserService {

    //create user
    void createUser(User user);

    //read users
    List<User> readAllUsers();

    User getUserById(Long id);

    User getUserByLogin(String login);

    //delete user
    void deleteById(Long id);

    //update user
    void update(User user);
}
