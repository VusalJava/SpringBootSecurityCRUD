package com.example.springbootcrud.controller;

import com.example.springbootcrud.repository.RoleDAO;
import com.example.springbootcrud.repository.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserDAO userDAO;
    private final RoleDAO roleDAO;

    public AdminController(UserDAO userDAO, RoleDAO roleDAO){
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
    }

    @GetMapping()
    public String listUsers(){

        return "users/show";
    }

}
