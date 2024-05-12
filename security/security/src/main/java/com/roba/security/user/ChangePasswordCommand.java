package com.roba.security.user;


import com.roba.security.auth.AuthenticationService;

public class ChangePasswordCommand implements Command {
    private final AuthenticationService userService;
    private final Integer userId;
    private final ChangePasswordRequest request;

    public ChangePasswordCommand(AuthenticationService userService, Integer userId, ChangePasswordRequest request) {
        this.userService = userService;
        this.userId = userId;
        this.request = request;
    }

    @Override
    public void execute() {
        userService.changeUserPassword(userId, request);
    }
}

