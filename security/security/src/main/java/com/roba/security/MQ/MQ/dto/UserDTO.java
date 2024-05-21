package com.roba.security.MQ.MQ.dto;



import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
@Builder
@Data
public class UserDTO implements Serializable {
    private Integer id;
    private String fullName;
    private String workEmail;
    private String Department;
    private String Position;
    private String TimeZone;
    private LocalDate hireDate;
    private double hourlyRate;
    private double salary;
    private String taxInfo;
    private Integer usedTimeOff;
    private Integer pendingTimeOff;
    private Integer balanceTimeOff;
    private double totalHoursWorked;
    private double WeeklyLimit;
    private LocalDate DateRemoved;
    private String PayType;
    private Integer PayRate;
    private Integer DailyLimit;
    private boolean TrackingEnabled;
    private boolean TimesheetsEnabled;
    private String Status;



    // Getters and setters
}
