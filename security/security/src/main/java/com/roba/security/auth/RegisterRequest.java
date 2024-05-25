package com.roba.security.auth;

import com.roba.security.organization.Organization;
import com.roba.security.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

    private String department;
    private String position;
    private String timeZone;
    private LocalDate hireDate;
    private double hourlyRate;
    private double salary;
    private String taxInfo;
    private Integer usedTimeOff;
    private Integer pendingTimeOff;
    private Integer balanceTimeOff;
    private double totalHoursWorked;
    private double weeklyLimit;
    private LocalDate dateRemoved;
    private String payType;
    private Integer payRate;
    private Integer dailyLimit;
    private boolean trackingEnabled;
    private boolean timesheetsEnabled;
    private String status;

}
