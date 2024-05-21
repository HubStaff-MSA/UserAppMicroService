package com.roba.security.user.Commands;


import com.roba.security.auth.AuthenticationResponse;
import com.roba.security.auth.AuthenticationService;
import com.roba.security.user.ChangePasswordRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    @Override
    public AuthenticationResponse getResult() {
        return null;
    }
}

