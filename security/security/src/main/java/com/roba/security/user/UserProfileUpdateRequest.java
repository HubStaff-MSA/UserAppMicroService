package com.roba.security.user;

import lombok.Data;

@Data
public class UserProfileUpdateRequest {
    private String fullName;
    private String WorkEmail;


    // Add other fields as needed for profile update
}
