package com.roba.security.auth;

import com.roba.security.organization.Organization;
import com.roba.security.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String fullName;
    private String password;
    private String workEmail;
    private Role role;
    private String organizationName;
    private Integer teamSize;
    private String website;


}
