package com.roba.security.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRespository extends JpaRepository<User, Integer> {
        Optional<User> findByworkEmail(String workEmail);
}
