package com.tarasPlus.bootcrud.controller;

import com.tarasPlus.bootcrud.model.User;
import com.tarasPlus.bootcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class RegistrationController {

    private UserService userService;
    private Environment environment;

    @Autowired
    public RegistrationController(UserService userService, Environment environment) {
        this.userService = userService;
        this.environment = environment;
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("message") String message, User user) {
        return "registration";
    }

    @PostMapping("/registration/user")
    public String regUser(@ModelAttribute("user") User user, Model model) {
        if (userService.addUser(user)) {
            return "redirect:/user";
        } else {
            model.addAttribute("message", environment.getRequiredProperty("invalidData"));
        }
        return "redirect:/registration";
    }
}
