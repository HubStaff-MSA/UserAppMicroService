package com.roba.security.user;

import com.roba.security.auth.AuthenticationRequest;
import com.roba.security.auth.AuthenticationService;
import com.roba.security.auth.RegisterRequest;
import com.roba.security.user.Commands.*;
import org.springframework.stereotype.Component;

@Component
public class CommandFactory {
    private final AuthenticationService userService;

    public CommandFactory(AuthenticationService userService) {
        this.userService = userService;
    }

    public Command createUpdateProfileCommand(Integer userId, UserProfileUpdateRequest request) {
        return new UpdateProfileCommand(userService, userId, request);
    }
    public Command createChangePasswordCommand(Integer userId, ChangePasswordRequest request) {
        return new ChangePasswordCommand(userService, userId, request);
    }
        public Command  createGetAllUsersCommand() {
            return new GetAllUsersCommand(userService);
        }
        public Command createGetUserByIdCommand(Integer userId) {
            return new GetUserByIdCommand(userId, userService);}

        public Command createGetUsersByRoleCommand(Role role) {
            return new GetUsersByRoleCommand(role, userService);
        }
    public Command createRegisterCommand(RegisterRequest request) {
        return new RegisterCommand(userService, request);
    }

    public Command createAuthenticateCommand(AuthenticationRequest request) {
        return new AuthenticateCommand(userService, request);
    }





}
