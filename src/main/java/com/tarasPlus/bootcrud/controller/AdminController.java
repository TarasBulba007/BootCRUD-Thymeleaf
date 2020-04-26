package com.tarasPlus.bootcrud.controller;

import com.tarasPlus.bootcrud.model.User;
import com.tarasPlus.bootcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {

    private UserService service;
    private Environment environment;

    @Autowired
    public AdminController(UserService service, Environment environment){
        this.service = service;
        this.environment = environment;
    }

    @GetMapping("/admin")
    public String userList(@ModelAttribute("user")User user,
                           @ModelAttribute("message") String message,
                           Model model){
        List<User> list =service.getAllUsers();
        model.addAttribute("list", list);
        return "admin";
    }

    @PostMapping(value = "/admin/add")
    public String userAdd(@ModelAttribute("user") User user, Model model, @ModelAttribute("role") String role) {

        if (!service.addUserAdmin(user, role)) {
            model.addAttribute("message", environment.getRequiredProperty("invalidData"));
        }
        return "redirect:/admin";
    }

    @PostMapping(value = "/admin/update")
    public String userUpdate(@ModelAttribute("user") User user, Model model, @ModelAttribute("role") String role) {
        if (!service.updateUser(user)) {
            model.addAttribute("message", environment.getRequiredProperty("invalidData"));
        }
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin/delete/{id}")
    public String userDelete(@PathVariable("id") Long id) {

        service.deleteUser(service.getUserById(id));
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin/edit_user/{id}")
    public String editUserForm(@PathVariable("id") Long id, Model model){
        model.addAttribute(service.getUserById(id));
        return "/user_edit";
    }

    @PostMapping(value = "/admin/edit_user/user")
    public String editUser(@ModelAttribute("user") User user, Model model){
        if (service.updateUser(user)){
            return "redirect:/admin";
        } else {
            model.addAttribute("message", environment.getRequiredProperty("invalidData"));
        }
        return "redirect:/admin";
    }
}
