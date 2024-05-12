package com.roba.security.user;

import com.roba.security.auth.AuthenticationService;

import java.util.List;

public class GetAllUsersCommand implements Command {
    private final AuthenticationService userService;

    public GetAllUsersCommand(AuthenticationService userService) {
        this.userService = userService;
    }

    @Override
    public void execute() {
         userService.getAllUsers();
    }
}
