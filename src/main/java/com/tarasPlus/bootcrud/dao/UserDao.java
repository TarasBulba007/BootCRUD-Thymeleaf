package com.tarasPlus.bootcrud.dao;

import com.tarasPlus.bootcrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {

    @Query("select user from User user left join fetch user.roles where user.username=:username")
    User findByLogin(@Param("username") String username);

    @Query("select user from User user left join fetch user.roles where user.id=:id")
    User getById(@Param("id") Long id);

    @Query("from User as user")
    List<User> findAll();
}