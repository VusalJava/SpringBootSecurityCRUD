package com.example.springbootcrud.controller;

import com.example.springbootcrud.domain.Role;
import com.example.springbootcrud.domain.User;
import com.example.springbootcrud.repository.RoleDAO;
import com.example.springbootcrud.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;


    public AdminController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public String listUsers(Model model){
        model.addAttribute("_users",userService.readAllUsers());

        return "admin/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id,Model model){
        User user = userService.getUserById(id);
        List<Role> roleList = userService.readAllRoles();
        model.addAttribute("user",user);
        model.addAttribute("roleList",roleList);

        return "admin/edit";
    }

    @PatchMapping("")
    public String updateUser(User user){
        userService.update(user);

        return "redirect:/admin";
    }

    @GetMapping("/new")
    public String newForm(User user,Model model){
        List<Role> roleList = userService.readAllRoles();
        model.addAttribute("user",user);
        model.addAttribute("roleList",roleList);

        return "admin/new";
    }

    @PostMapping("")
    public String create(@ModelAttribute("user") User user){
        userService.createUser(user);

        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.deleteById(id);

        return "redirect:/admin";
    }



}
