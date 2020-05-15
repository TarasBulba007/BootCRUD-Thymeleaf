package com.tarasPlus.bootcrud.controller;

import com.tarasPlus.bootcrud.model.Role;
import com.tarasPlus.bootcrud.model.User;
import com.tarasPlus.bootcrud.service.RoleService;
import com.tarasPlus.bootcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AdminController {

    private UserService service;
    private RoleService roleService;
    private Environment environment;

    @Autowired
    public AdminController(UserService service, RoleService roleService, Environment environment){
        this.service = service;
        this.roleService = roleService;
        this.environment = environment;
    }

    @GetMapping("/admin")
    public String userList(@ModelAttribute("user")User user,
                           @ModelAttribute("message") String message,
                           Model model){
        List<User> list = service.getAllUsers();
        model.addAttribute("list", list);
        model.addAttribute("allRoles", service.findAll());
        return "admin";
    }

    @PostMapping(value = "/admin/add")
    public String userAdd(@ModelAttribute("user") User newUser, Model model, @ModelAttribute("role") String role) {
        if (!service.addUserAdmin(newUser, role)) {
            model.addAttribute("message", environment.getRequiredProperty("invalidData"));
        }
        return "redirect:/admin";
    }

//    @PostMapping(value = "/admin/update")
//    public String userUpdate(@ModelAttribute("user") User user, Model model, @ModelAttribute("role") String role) {
//        if (!service.updateUser(user, roles)) {
//            model.addAttribute("message", environment.getRequiredProperty("invalidData"));
//        }
//        return "redirect:/admin";
//    }

    @GetMapping(value = "/admin/delete")
    public String userDelete(@RequestParam("id") Long id) {

        service.deleteUser(service.getUserById(id));
        return "redirect:/admin";
    }

//    @GetMapping(value = "/admin/edit_user")
//    public String editUserForm(@RequestParam("id") Long id, Model model){
//        model.addAttribute(service.getUserById(id));
//        return "/user_edit";
//    }

    @PostMapping(value = "/admin/edit_user")
    public String editUser(@ModelAttribute User user, Model model,
                           @RequestParam(value = "rolesId") Long[] rolesId){
        Set<Role> roles = new HashSet<>();
        for (Long id : rolesId){
            roles.add(roleService.findById(id).get());
        }

        if (service.updateUser(user, roles)){
            return "redirect:/admin";
        } else {
            model.addAttribute("message", environment.getRequiredProperty("invalidData"));
        }
        return "redirect:/admin";
    }

    @GetMapping("/all-roles")
    public @ResponseBody
    Set<Role> userRoles() {
        return ((Set<Role>) service.findAll());
    }
}
