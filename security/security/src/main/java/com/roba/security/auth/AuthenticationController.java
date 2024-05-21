package com.roba.security.auth;

import com.roba.security.user.Commands.Command;
import com.roba.security.user.CommandFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;
    private final CommandFactory commandFactory;

//    @PostMapping("/register")
//    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
//        Command command = commandFactory.createRegisterCommand(request);
//       command.execute();
//        //return ResponseEntity.ok().build();
//         return ResponseEntity.ok(service.register(request));
//    }
//
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
//        Command command = commandFactory.createAuthenticateCommand(request);
//        command.execute();
//        //return ResponseEntity.ok().build();
//        return ResponseEntity.ok(service.authenticate(request));
//    }


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        Command command = commandFactory.createRegisterCommand(request);
        command.execute();
        AuthenticationResponse response = command.getResult();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        Command command = commandFactory.createAuthenticateCommand(request);
        command.execute();
        AuthenticationResponse response = command.getResult();
        return ResponseEntity.ok(response);
    }



}
