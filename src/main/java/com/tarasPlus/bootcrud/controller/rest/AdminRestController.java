package com.tarasPlus.bootcrud.controller.rest;

import com.tarasPlus.bootcrud.model.Role;
import com.tarasPlus.bootcrud.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

    private RoleService roleService;

    public AdminRestController(RoleService roleService){
        this.roleService = roleService;
    }

    @GetMapping("/all-roles")
    public Set<Role> userRoles() {
        return new HashSet<>(roleService.findAll());
    }
}
