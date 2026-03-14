package com.example.UserManager.service;


import com.example.UserManager.entity.User;
import com.example.UserManager.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //methode to create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // methode to delete a user by id
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    //methode to get all user
    public List <User> getAllUsers() {
        return userRepository.findAll();
    }


}
