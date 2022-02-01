package com.example.springbootcrud.service;

import com.example.springbootcrud.domain.User;
import com.example.springbootcrud.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public void createUser(User user) {
        userDAO.save(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        userDAO.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.findById(id).orElse(null);
    }

    @Override
    public User getUserByLogin(String login) {
        return userDAO.findByLogin(login);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }

    @Override
    public List<User> readAllUsers() {
        return userDAO.findAll();
    }
}
