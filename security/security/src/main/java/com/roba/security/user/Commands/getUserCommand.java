package com.roba.security.user.Commands;

import com.roba.security.MQ.MQ.dto.UserDTO;
import com.roba.security.auth.AuthenticationResponse;
import com.roba.security.auth.AuthenticationService;
import com.roba.security.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor(force = true)
public class getUserCommand implements Command{

        private final AuthenticationService userService;
        private  Integer userId;
    private UserDTO returned;


        @Override
        public void execute() {
            User user = userService.getUserById(this.userId).orElse(null);
            if (user != null) {
                this.returned = convertToUserDTO(user);
            }

        }

        @Override
        public AuthenticationResponse getResult() {
            return null;
        }

        public void build(String payload) {
             this.userId = Integer.parseInt(payload.split(",")[0]);


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







