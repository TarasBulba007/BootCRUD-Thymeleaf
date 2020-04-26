package com.tarasPlus.bootcrud.service;

import com.tarasPlus.bootcrud.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    void deleteUser(User user);

    boolean updateUser (User user);

    boolean addUser(User user);

    boolean addUserAdmin(User user, String access);

    boolean isExistLogin(String login);

    boolean notNullDataUser(User user);
}
