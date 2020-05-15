package com.tarasPlus.bootcrud.service;

import com.tarasPlus.bootcrud.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleService extends JpaRepository<Role, Long> {
}
