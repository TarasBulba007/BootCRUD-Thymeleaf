package com.tarasPlus.bootcrud.service;

import com.tarasPlus.bootcrud.dao.RoleDao;
import com.tarasPlus.bootcrud.dao.UserDao;
import com.tarasPlus.bootcrud.model.Role;
import com.tarasPlus.bootcrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Role userRole;
    private Role adminRole;
    private UserDao userDao;
    private RoleDao roleDao;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public void deleteUser(User user) {
        userDao.delete(user);
    }

    @Override
    public boolean updateUser(User user) {
        if (notNullDataUser(user)) {
            passwordEncode(user);
            userDao.saveAndFlush(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean addUser(User user) {
        if (user.getUsername() != null) {
            addUserRole((user));
            user.setPassword(bCryptPasswordEncoder
                    .encode(user.getPassword()));
            userDao.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean addUserAdmin(User user, String access) {
        if (notNullDataUser(user) && !isExistLogin(user.getUsername())) {
            initRole(user, access);
            passwordEncode(user);
            userDao.saveAndFlush(user);
        }
        return false;
    }

    @Override
    @Transactional
    public boolean isExistLogin(String login) {
        return (userDao.findByLogin(login) != null);
    }

    @Override
    public boolean notNullDataUser(User user) {
        return true;
    }

    private void passwordEncode(User user) {
        if (user.getPassword().length() < 30) {
            String password = user.getPassword();
            user.setPassword(bCryptPasswordEncoder.encode(password));
        }
    }

    private void addUserRole(User user) {
        if (userRole == null) {
            userRole = roleDao.findById(2L);
        }
        user.getRoles().add(userRole);
    }

    private void initRole(User user, String access) {
        if (access.contains("ADMIN")) {
            addAdminRole(user);
        } else {
            addUserRole(user);
        }
    }

    private void addAdminRole(User user) {
        if (adminRole == null) {
            adminRole = roleDao.findById(1L);
        }
        user.getRoles().add(adminRole);
    }
}
