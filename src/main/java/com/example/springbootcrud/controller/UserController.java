package com.example.springbootcrud.controller;

import com.example.springbootcrud.domain.User;
import com.example.springbootcrud.repository.RoleDAO;
import com.example.springbootcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final RoleDAO roleDAO;

    @Autowired
    public UserController(UserService userService, RoleDAO roleDAO) {
        this.userService = userService;
        this.roleDAO = roleDAO;
    }

    @GetMapping()
    public String printUsers(Model model){
        model.addAttribute("_users",userService.readAllUsers());
        return "users/list";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") Long id, Model model){
        model.addAttribute("_user",userService.getUserById(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("_user") User user){
        return "users/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("_user") User user){
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") Long id,Model model){
        model.addAttribute("_user",userService.getUserById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("_user") User user){
        userService.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/users";
    }




}