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
public class UserController {

    private UserService service;
    private Environment environment;

    @Autowired
    public UserController(UserService service, Environment environment) {
        this.service = service;
        this.environment = environment;
    }

    @GetMapping("/user")
    public String showUser(Model model, Principal principal) {
         User user = (User) ((Authentication) principal).getPrincipal();
        model.addAttribute("user", user);
      //  System.out.println("UserName: " + user.getUsername());
        return "userPage";
    }

    @PostMapping("/upgrade/user")
    public String upgrade(@ModelAttribute("user") User user, Model model) {
        System.out.println("Update username: " + user.getUsername() + " Birthdate: " + user.getBirth_date());
        if (service.updateUser(user)) {
            return "redirect:/user";
        } else {
            model.addAttribute("message", environment.getRequiredProperty("invalidData"));
        }
        return "redirect:/user";
    }

    @GetMapping("/access_denied")
    public String accessDenied() {
        return "accessDeniedView";
    }
}
