package com.roba.security.auth;

import com.roba.security.config.JwtService;


import com.roba.security.organization.Organization;
import com.roba.security.organization.OrganizationRepository;
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


import java.util.Optional;

@Service
@RequiredArgsConstructor

public class AuthenticationService {
    private final UserRespository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private  final AuthenticationManager authenticationManager;
    private final TokenRepository tokenRepository;
    private final Emailvalidator emailvalidator;
    private final OrganizationRepository organizationRepository;

    public AuthenticationResponse register(RegisterRequest request) {
        //boolean isValidEmail =emailvalidator.test(request.getWorkEmail());
        //if(!isValidEmail) {throw new IllegalStateException("Invalid email");}
        Optional<User> existingUser = repository.findByworkEmail(request.getWorkEmail());
        if (existingUser.isPresent()) {
            throw new IllegalStateException("Email is already in use");
        }
        Role role;
        if(request.getRole().equals("team_member")) {
            role = Role.USER;
        }else {
           role = request.getRole();
        }
        if (role == Role.OWNER) {
            // Create organization
            Organization organization = Organization.builder()
                    .name(request.getOrganizationName())
                    .teamSize(request.getTeamSize())
                    .websiteURL(request.getWebsite())// Assuming organization name is provided in the request
                    .build();
            Organization savedOrganization = organizationRepository.save(organization);

            var user = User.builder()
                    .fullName(request.getFullName())
                    .workEmail(request.getWorkEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(request.getRole())
                    .organization(savedOrganization)
                    .build();
            var savedUser = repository.save(user);
            var jwtToken = jwtService.generateToken(user);

            saveUserToken(savedUser, jwtToken);
            return AuthenticationResponse.builder().token(jwtToken).build();
        }
        else if(role == Role.USER){
            // Fetch organization by name
            Optional<Organization> organizationOptional = organizationRepository.findByName(request.getOrganizationName());
            if (organizationOptional.isEmpty()) {
                throw new IllegalStateException("Organization not found");
            }
            Organization organization = organizationOptional.get();

            var user = User.builder()
                    .fullName(request.getFullName())
                    .workEmail(request.getWorkEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.USER)
                    .organization(organization)
                    .build();
            var savedUser = repository.save(user);
            var jwtToken = jwtService.generateToken(user);

            saveUserToken(savedUser, jwtToken);
            return AuthenticationResponse.builder().token(jwtToken).build();
        }else{
            throw new IllegalStateException("Role not supported");

        }

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
