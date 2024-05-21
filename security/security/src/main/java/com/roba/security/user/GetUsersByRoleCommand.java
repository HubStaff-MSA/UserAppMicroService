package com.roba.security.user;

import com.roba.security.auth.AuthenticationResponse;
import com.roba.security.auth.AuthenticationService;
import com.roba.security.user.Commands.Command;

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

    @Override
    public AuthenticationResponse getResult() {
        return null;
    }
//    public void build(String payload) {
//        this.organizationID = Integer.parseInt(payload.split(",")[0]);
//        this.userID = Integer.parseInt(payload.split(",")[1]);
//
//    }
}
