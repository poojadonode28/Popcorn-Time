package com.jatin.popcornTime.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.jatin.popcornTime.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);
}