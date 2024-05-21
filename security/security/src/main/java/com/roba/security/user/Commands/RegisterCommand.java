package com.roba.security.user.Commands;

import com.roba.security.auth.AuthenticationResponse;
import com.roba.security.auth.AuthenticationService;
import com.roba.security.auth.RegisterRequest;

public class RegisterCommand implements Command {
    private final AuthenticationService service;
    private final RegisterRequest request;
    private AuthenticationResponse result;

    public RegisterCommand(AuthenticationService service, RegisterRequest request) {
        this.service = service;
        this.request = request;
    }

    @Override
    public void execute() {
        result = service.register(request);
    }
    @Override
    public AuthenticationResponse getResult() {
        return result;
    }
    public void build(String payload) {
//        this.organizationID = Integer.parseInt(payload.split(",")[0]);
//        this.userID = Integer.parseInt(payload.split(",")[1]);

    }



}
