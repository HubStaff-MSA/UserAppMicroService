package com.roba.security.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class BusinessOwnerController {
    @GetMapping
    public String get() {
        return "get in admin";
    }
    @PostMapping
    public String post(){ return "POST:IN ADMIN";}
}
