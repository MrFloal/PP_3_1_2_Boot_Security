package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.dao.UserRepository;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserDetailsServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserDetailsServiceImpl userService;

    @Autowired
    public UserController(UserDetailsServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String userPage(Principal principal, Model model) {
        model.addAttribute("user", userService.findByUsername(principal.getName()));
        return ("users/userPage");
    }

}