package com.roba.security.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
        Optional<User> findByworkEmail(String workEmail);

        List<User> findByRole(Role role);

        //  Optional<User> findByWorkEmail(String workEmail);
}
