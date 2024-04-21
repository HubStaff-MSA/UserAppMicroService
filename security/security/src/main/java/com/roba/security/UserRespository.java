package com.roba.security;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRespository extends JpaRepository<User, Integer> {
        Optional<User> findByEmail(String workEmail);
}
