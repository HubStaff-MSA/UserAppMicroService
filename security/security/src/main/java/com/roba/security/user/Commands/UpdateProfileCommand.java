package com.roba.security.user.Commands;

import com.roba.security.auth.AuthenticationResponse;
import com.roba.security.auth.AuthenticationService;
import com.roba.security.user.UserProfileUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @Override
    public AuthenticationResponse getResult() {
        return null;
    }
}
