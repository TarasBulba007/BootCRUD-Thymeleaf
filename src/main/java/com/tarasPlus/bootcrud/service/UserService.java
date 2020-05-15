package com.tarasPlus.bootcrud.service;

import com.tarasPlus.bootcrud.model.Role;
import com.tarasPlus.bootcrud.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    void deleteUser(User user);

    boolean updateUser (User user, Set<Role> roles);

    boolean addUser(User user);

    boolean addUserAdmin(User user, String access);

    boolean isExistLogin(String login);

    boolean notNullDataUser(User user);

    List<Role> findAll();
}
