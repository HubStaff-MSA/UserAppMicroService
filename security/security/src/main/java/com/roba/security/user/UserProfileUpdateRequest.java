package com.roba.security.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
@Setter
public class UserProfileUpdateRequest {
    private String fullName;
    private String WorkEmail;
    private String payload;
    private String command;




    // Add other fields as needed for profile update
}
