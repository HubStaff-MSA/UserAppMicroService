package com.roba.security.user;

import com.roba.security.auth.AuthenticationRequest;
import com.roba.security.auth.AuthenticationResponse;
import com.roba.security.auth.AuthenticationService;

public class AuthenticateCommand implements Command {
    private final AuthenticationService service;
    private final AuthenticationRequest request;
    private AuthenticationResponse result;
    public AuthenticateCommand(AuthenticationService service, AuthenticationRequest request) {
        this.service = service;
        this.request = request;
    }

    @Override
    public void execute() {
        result = service.authenticate(request);
    }
    @Override
    public AuthenticationResponse getResult() {
        return result;
    }
}






