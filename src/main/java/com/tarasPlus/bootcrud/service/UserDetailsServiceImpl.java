package com.tarasPlus.bootcrud.service;

import com.tarasPlus.bootcrud.dao.UserDao;
import com.tarasPlus.bootcrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDao userdao;

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao){
        this.userdao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userFromDB =userdao.findByLogin(username);

        if (userFromDB == null){
                throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

        return userFromDB;
    }
}
