package com.roba.security.user;

import com.roba.security.auth.AuthenticationService;

public class UpdateProfileCommand implements Command{
    private final AuthenticationService userService;
    private final Integer userId;
    private final UserProfileUpdateRequest request;


    public UpdateProfileCommand(AuthenticationService userService, Integer userId, UserProfileUpdateRequest request) {
        this.userService = userService;
        this.userId = userId;
        this.request = request;
    }

    @Override
    public void execute() {
        userService.updateUserProfile(userId, request);
    }
}
