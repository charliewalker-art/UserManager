package com.example.UserManager.service;

import com.example.UserManager.entity.Role;
import com.example.UserManager.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // get all roles
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    // get role by id
    public Role getRoleById(Integer id) {
        return roleRepository.findById(id).orElse(null);
    }

    // create new role
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }
}
