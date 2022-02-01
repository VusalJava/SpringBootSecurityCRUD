package com.example.springbootcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", required = false,defaultValue = "World") String name, Model model){
        model.addAttribute("name",name);

        return "users/hello";
    }

}
