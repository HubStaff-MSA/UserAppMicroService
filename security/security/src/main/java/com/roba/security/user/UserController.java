package com.roba.security.user;

import com.roba.security.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;
 import com.roba.security.user.CommandFactory;
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final CommandFactory commandFactory;
   //  @Autowired
    private final AuthenticationService userService;

    @PutMapping("/{userId}/profile")
//    public ResponseEntity<?> updateProfile(@PathVariable("userId") Integer userId, @RequestBody UserProfileUpdateRequest request) {
//        System.out.println("gg");
//        userService.updateUserProfile(userId, request);
//        return ResponseEntity.ok().build();
//    }

    public ResponseEntity<?> updateProfile(@PathVariable("userId") Integer userId, @RequestBody UserProfileUpdateRequest request) {
        Command command = commandFactory.createUpdateProfileCommand(userId, request);
        command.execute();
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{userId}/password")
//    public ResponseEntity<?> changePassword(@PathVariable("userId") Integer userId, @RequestBody ChangePasswordRequest request) {
//        userService.changeUserPassword(userId, request);
//        return ResponseEntity.ok().build();
//    }
    public ResponseEntity<?> changePassword(@PathVariable("userId") Integer userId, @RequestBody ChangePasswordRequest request) {
        Command command = commandFactory.createChangePasswordCommand(userId, request);
        command.execute();
        return ResponseEntity.ok().build();
    }


    @GetMapping("/all")
    public List<User> getAllUsers() {
        Command command = commandFactory.createGetAllUsersCommand();
        command.execute();
        return userService.getAllUsers();
    }


    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable Integer userId) {
        Command command = commandFactory.createGetUserByIdCommand(userId);
        command.execute();
        return userService.getUserById(userId);
    }

    @GetMapping("/role/{role}")
    public List<User> getUsersByRole(@PathVariable Role role) {
        Command command = commandFactory.createGetUsersByRoleCommand(role);
        command.execute();
        return userService.getUsersByRole(role);
    }





}
