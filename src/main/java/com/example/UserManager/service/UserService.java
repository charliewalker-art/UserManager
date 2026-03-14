package com.example.UserManager.service;


import com.example.UserManager.entity.User;
import com.example.UserManager.repository.RoleRepository;
import com.example.UserManager.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.UserManager.entity.Role;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    // get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // get user by id
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    // create new user
    public User createUser(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Role role = roleRepository.findByName("USER").orElse(null);

        if (role == null) {
            throw new RuntimeException("Default role USER not found");
        }

        user.setRole(role);

        return userRepository.save(user);
    }

    // delete user by id
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}