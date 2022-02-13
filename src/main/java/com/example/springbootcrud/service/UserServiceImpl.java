package com.example.springbootcrud.service;

import com.example.springbootcrud.model.Role;
import com.example.springbootcrud.model.User;
import com.example.springbootcrud.repository.RoleRepository;
import com.example.springbootcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Transactional
    @Override
    public void createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        userRepository.save(user);
    }


    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
/*
        User user = userRepository.findById(id).orElse(null);
       Set<Role> roles = user.getRoles();
        while (roles.iterator().hasNext()){
            Role role = roles.iterator().next();
            List<User> users = role.getUsers();
            users.remove(user);
            role.setUsers(users);
            roleRepository.save(role);
            roles.remove(role);
        }
        user.setRoles(roles);
        userRepository.save(user);*/
        userRepository.deleteById(id);
    }

    @Override
    public List<User> readAllUsers() {
        return userRepository.findAll();
    }

}
