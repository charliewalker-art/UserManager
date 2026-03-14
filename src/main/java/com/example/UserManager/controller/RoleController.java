package com.example.UserManager.controller;


import com.example.UserManager.entity.Role;
import com.example.UserManager.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor

public class RoleController {

    private final RoleService roleService ;

    //get all roles
    @GetMapping
        public List<Role> getAllRoles(){
            return roleService.getAllRoles();
        }

        //get role by id
        @GetMapping("/{id}")
        public Role getRoleById(@PathVariable Integer id){
            return roleService.getRoleById(id);
        }

        //create new role
        @PostMapping
        public Role createRole(@RequestBody Role role) {
            return roleService.createRole(role);
        }
}
