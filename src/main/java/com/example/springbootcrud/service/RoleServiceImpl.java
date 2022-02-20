package com.example.springbootcrud.service;

import com.example.springbootcrud.model.Role;
import com.example.springbootcrud.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> readAllRoles() {
        return roleRepository.findAll() ;
    }

    @Override
    public Role findRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

}
