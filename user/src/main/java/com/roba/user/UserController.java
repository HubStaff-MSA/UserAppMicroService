package com.roba.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
private final UserService service;
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
//    public void save(@RequestBody User user){
//        service.saveUser(user);
//
//    }
    public void createUser(@RequestBody UserRequest userRequest){
        userService.createUser(userRequest);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
   public List<UserResponse> getAllUsers(){
       return userService.getAllUsers();
    }
}
