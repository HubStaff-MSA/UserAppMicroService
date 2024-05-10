package com.roba.security.user;

import com.roba.security.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {


    private final AuthenticationService userService;

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


    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/role/{role}")
    public List<User> getUsersByRole(@PathVariable Role role) {
        return userService.getUsersByRole(role);
    }
}
