package com.example.UserManager.service;

import com.example.UserManager.entity.Role;
import com.example.UserManager.entity.User;
import com.example.UserManager.exception.UserException;
import com.example.UserManager.repository.RoleRepository;
import com.example.UserManager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    // get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // get user by id
    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserException("User not found"));
    }

    // create new user
    public User createUser(User user) {

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserException("Email already exists");
        }

        Role role = roleRepository.findByName("USER").orElse(null);

        if (role == null) {
            throw new UserException("Default role USER not found");
        }

        user.setRole(role);

        return userRepository.save(user);
    }

    // delete user by id
    public void deleteUser(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new UserException("User not found");
        }

        userRepository.deleteById(id);
    }

    // update user
    public User updateUser(Integer id, User userDetails) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            throw new UserException("User not found");
        }

        if (!user.getEmail().equals(userDetails.getEmail()) &&
                userRepository.existsByEmail(userDetails.getEmail())) {
            throw new UserException("Email already exists");
        }

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());

        return userRepository.save(user);
    }
}