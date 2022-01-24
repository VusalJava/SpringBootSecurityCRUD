package com.example.springbootcrud.repository;


import com.example.springbootcrud.domain.User;

import java.util.List;

public interface UserDAO {

    //create user
    void createUser(User user);

    //read users
    List<User> readAllUsers();

    User getUserById(Long id);

    //delete user
    void deleteById(Long id);

    //update user
    void update(User user);




}
