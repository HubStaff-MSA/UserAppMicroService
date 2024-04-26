package com.roba.security.auth;

import com.roba.security.config.JwtService;


import com.roba.security.user.Role;
import com.roba.security.user.User;
import com.roba.security.user.UserRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthenticationService {
    private final UserRespository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private  final AuthenticationManager authenticationManager;



    public AuthenticationResponse register(RegisterRequest request) {
        var user= User.builder()
                .fullName(request.getFullName())
                .workEmail(request.getWorkEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken=jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getWorkEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByworkEmail(request.getWorkEmail())
                .orElseThrow();
        var jwtToken=jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
