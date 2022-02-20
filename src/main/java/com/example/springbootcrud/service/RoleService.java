package com.example.springbootcrud.service;

import com.example.springbootcrud.model.Role;

import java.util.List;

public interface RoleService {
    //read roles
    List<Role> readAllRoles();

    Role findRoleById(Long id);
}
