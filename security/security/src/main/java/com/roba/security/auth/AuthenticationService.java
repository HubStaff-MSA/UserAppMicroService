package com.roba.security.auth;

import com.roba.security.config.JwtService;


import com.roba.security.token.Token;
import com.roba.security.token.TokenRepository;
import com.roba.security.token.TokenType;
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
    private final TokenRepository tokenRepository;


    public AuthenticationResponse register(RegisterRequest request) {
        var user= User.builder()
                .fullName(request.getFullName())
                .workEmail(request.getWorkEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        var savedUser =repository.save(user);
        var jwtToken=jwtService.generateToken(user);

        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
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
        revokeAllUserTokens(user);
          saveUserToken(user,jwtToken);

        return AuthenticationResponse.builder().token(jwtToken).build();

    }
    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder().user(user).token(jwtToken).tokenType(TokenType.BEARER).revoked(false).expired(false).build();
        tokenRepository.save(token);
    }
}
