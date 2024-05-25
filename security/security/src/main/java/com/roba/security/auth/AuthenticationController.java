package com.roba.security.auth;

import com.roba.security.MQ.MQ.dto.CommandSender;
import com.roba.security.UserCache.UserService;
import com.roba.security.config.JwtAuthenticationFilter;
import com.roba.security.user.Commands.Command;
import com.roba.security.user.CommandFactory;
import com.roba.security.user.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;
    private final CommandFactory commandFactory;
    private final UserService userService;
    private final RabbitTemplate rabbitTemplate;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

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

    @PostMapping("/project")
    public Object ReceivedCommand( @RequestBody CommandSender commandSender) {

        return rabbitTemplate.convertSendAndReceive("commandQueue", commandSender);


    }



    @PostMapping("/payment")
    public Object ReceivedCommand2( @RequestBody CommandSender commandSender) {

        return rabbitTemplate.convertSendAndReceive("commandQueue", commandSender);

    }


//
//    @GetMapping("/cached")
//    public String getCachedUser() {
//        User cachedUser = userService.getUser();
//        if (cachedUser != null) {
//            return "Using cached user: " + cachedUser.getName();
//        } else {
//            return "No cached user available";
//        }


}
