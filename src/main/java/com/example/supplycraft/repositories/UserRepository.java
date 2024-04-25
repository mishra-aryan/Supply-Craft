package com.example.supplycraft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.supplycraft.models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Find user by username
    Optional<User> findByUsername(String username);
    
    // Find user by email
    Optional<User> findByEmail(String email);
    
    // Find user by id
    Optional<User> findById(Long id);
    
    // Save or update user
    User save(User user);
    
    // Delete user by id
    void deleteById(Long id);
    
}
