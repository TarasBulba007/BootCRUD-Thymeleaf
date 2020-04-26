package com.tarasPlus.bootcrud.dao;

import com.tarasPlus.bootcrud.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleDao extends JpaRepository<Role, Integer> {

    @Query("SELECT role from Role role WHERE role.role=:role")
    Role findByRole(@Param("role") String role);

    @Query("SELECT u from Role u WHERE u.id=:id")
    Role findById(@Param("id") Long id);
}
