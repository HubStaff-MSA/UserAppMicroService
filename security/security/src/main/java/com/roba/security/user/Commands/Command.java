package com.roba.security.user.Commands;

import com.roba.security.auth.AuthenticationResponse;

public interface Command {
     void execute();
     AuthenticationResponse getResult();
}
