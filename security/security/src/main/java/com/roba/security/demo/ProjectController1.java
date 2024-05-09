package com.roba.security.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/projects")

public class ProjectController1 {


    @GetMapping
    public String get() {
        return "get controller";
    }

    @PostMapping
    public String post() {
        return "post controller";
    }
}
