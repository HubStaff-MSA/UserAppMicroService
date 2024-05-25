package com.roba.security.user.Commands;

import com.roba.security.MQ.MQ.dto.UserDTO;
import com.roba.security.auth.AuthenticationService;
import com.roba.security.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor(force = true)
public class UsersPayRates {

    private final AuthenticationService userService;
    private List<Integer> userIds;
    private Map<Integer, Integer> returned;

    public UsersPayRates(AuthenticationService authenticationService) {
        this.userService = authenticationService;
    }

    public void execute() {
        returned = new HashMap<>();
        for (Integer userId : userIds) {
            User user = userService.getuserById(userId);
            if (user != null) {
                UserDTO userDTO = convertToUserDTO(user);
                returned.put(userId, user.getPayRate()); // Or user.getHourlyRate(), depending on your requirement
            }
        }
    }

    public Map<Integer, Integer> getResult() {
        return returned;
    }

    public void build(Object payload) {
        this.userIds = (List<Integer>) payload;
    }

    private UserDTO convertToUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .workEmail(user.getWorkEmail())
                .Department(user.getDepartment())
                .Position(user.getPosition())
                .TimeZone(user.getTimeZone())
                .hireDate(user.getHireDate())
                .hourlyRate(user.getHourlyRate())
                .salary(user.getSalary())
                .taxInfo(user.getTaxInfo())
                .usedTimeOff(user.getUsedTimeOff())
                .pendingTimeOff(user.getPendingTimeOff())
                .balanceTimeOff(user.getBalanceTimeOff())
                .totalHoursWorked(user.getTotalHoursWorked())
                .WeeklyLimit(user.getWeeklyLimit())
                .DateRemoved(user.getDateRemoved())
                .PayType(user.getPayType())
                .PayRate(user.getPayRate())
                .DailyLimit(user.getDailyLimit())
                .TrackingEnabled(user.isTrackingEnabled())
                .TimesheetsEnabled(user.isTimesheetsEnabled())
                .Status(user.getStatus())
                .build();
    }
}
