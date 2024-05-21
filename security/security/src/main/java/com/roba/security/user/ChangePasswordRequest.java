package com.roba.security.user;


import lombok.Data;

@Data
public class ChangePasswordRequest {
    private String currentPassword;
    private String newPassword;
//    private String payload;
//    private String command;
   // private String workEmail;
}
