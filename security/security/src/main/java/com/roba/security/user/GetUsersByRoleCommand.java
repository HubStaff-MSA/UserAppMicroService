package com.roba.security.user;

import com.roba.security.auth.AuthenticationService;

import java.util.List;

public class GetUsersByRoleCommand implements Command {


    private final Role role;
    private final AuthenticationService userService;

    public GetUsersByRoleCommand(Role role, AuthenticationService userService) {
        this.role = role;
        this.userService = userService;
    }

    @Override
    public void execute() {
         userService.getUsersByRole(role);
    }
}
