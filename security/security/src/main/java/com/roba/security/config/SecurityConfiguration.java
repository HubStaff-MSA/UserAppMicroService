package com.roba.security.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;


import static com.roba.security.user.Permission.*;
import static com.roba.security.user.Role.ORGANIZATION_MANAGER;
import static com.roba.security.user.Role.OWNER;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

            .csrf(csrf -> csrf.disable()) // Disable CSRF protection
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/v1/auth/register").permitAll()// Allow access to public endpoints
                                .requestMatchers("api/users/**").permitAll()
                                .requestMatchers("api/v2/control/**").permitAll()
                                .requestMatchers("api/sendCommand").permitAll()
                                .requestMatchers("/api/v1/auth/project/**").hasAnyRole(OWNER.name(),ORGANIZATION_MANAGER.name())//allow access by biz owner to admin endpoint
                                .requestMatchers(HttpMethod.GET,"/api/v1/project/**").hasAnyAuthority(PROJECT_READ.name())
                                .requestMatchers(HttpMethod.PUT,"/api/v1/project/**").hasAnyAuthority(PROJECT_UPDATE.name())
                                .requestMatchers(HttpMethod.POST,"/api/v1/auth/project/**").hasAnyAuthority(PROJECT_CREATE.name())
                                .requestMatchers(HttpMethod.DELETE,"/api/v1/project/**").hasAnyAuthority(PROJECT_DELETE.name())

                                .requestMatchers("/api/v1/auth/payment/**").hasAnyRole(OWNER.name())
                                .requestMatchers("/payroll/**").hasAnyRole(OWNER.name())
                                .anyRequest().authenticated() // Require authentication for other requests
                )
                .sessionManagement(sessionManagement ->
                        sessionManagement
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout -> // Customizing logout configuration
                        logout
                                .logoutUrl("/api/v1/auth/logout")
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler( (request, response, authentication) -> SecurityContextHolder.clearContext()));



//                .logout()
//                .logoutUrl("/api/v1/auth/logout")
//                .addLogoutHandler(logoutHandler)
//                .logoutSuccessHandler(
//                        (request, response, authentication) -> SecurityContextHolder.clearContext()
//                );
        return http.build();
    }







}
