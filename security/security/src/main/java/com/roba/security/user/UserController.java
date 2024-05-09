package com.roba.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/{userId}/profile")
    public ResponseEntity<?> updateProfile(@PathVariable("userId") Integer userId, @RequestBody UserProfileUpdateRequest request) {
        userService.updateUserProfile(userId, request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}/password")
    public ResponseEntity<?> changePassword(@PathVariable("userId") Integer userId, @RequestBody ChangePasswordRequest request) {
        userService.changeUserPassword(userId, request);
        return ResponseEntity.ok().build();
    }
}
