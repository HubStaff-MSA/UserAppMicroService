package com.roba.security.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/tokens")
    public ResponseEntity<Token> createToken(@RequestBody Token token) {
        tokenService.saveToken(token);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/tokens/{id}")
    public ResponseEntity<Token> getToken(@PathVariable Integer id) {
        Token token = tokenService.getToken(id);
        if (token != null) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.notFound().build();
    }
}

