package com.example.UserManager.repository;

import com.example.UserManager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    //methode to search for user by email
    Optional<User> findByEmail(String email);

}