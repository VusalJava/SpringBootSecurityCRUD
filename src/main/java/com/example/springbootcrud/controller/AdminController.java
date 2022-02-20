package com.example.springbootcrud.controller;

import com.example.springbootcrud.model.Role;
import com.example.springbootcrud.model.User;
import com.example.springbootcrud.service.RoleService;
import com.example.springbootcrud.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService){
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String listUsers(Model model, Authentication authentication){
        model.addAttribute("userAuthorized", authentication.getPrincipal());
        model.addAttribute("_users",userService.readAllUsers());
        model.addAttribute("newUser",new User());
        model.addAttribute("roleList",roleService.readAllRoles());

        return "admin/admin-page";
    }


    @PatchMapping("/user/edit/{id}")
    public String updateUser(@ModelAttribute("user") User user,@RequestParam("idRoles") List<Long> idRoles){
        Set<Role> roleSet = new HashSet<>();
        for (Long idRole : idRoles) {
            roleSet.add(roleService.findRoleById(idRole));
        }
        user.setRoles(roleSet);
        userService.update(user);

        return "redirect:/admin";
    }


    @PostMapping("/user/new")
    public String create(@ModelAttribute("user") User user,@RequestParam("idRoles") List<Long> idRoles){
        Set<Role> roleSet = new HashSet<>();
        for (Long idRole : idRoles) {
            roleSet.add(roleService.findRoleById(idRole));
        }
        user.setRoles(roleSet);
        userService.createUser(user);

        return "redirect:/admin";
    }

    @DeleteMapping("/user/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.deleteById(id);

        return "redirect:/admin";
    }



}
