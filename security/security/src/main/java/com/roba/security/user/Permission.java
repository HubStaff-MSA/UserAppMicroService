package com.roba.security.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    PROJECT_READ("project:read"),
    PROJECT_UPDATE("project:update"),
    PROJECT_CREATE("project:create"),
    PROJECT_DELETE("project:delete"),
    ORGANIZATION_CREATE("organization:create"),
    ORGANIZATION_DELETE("organization:delete"),
    ORGANIZATION_UPDATE("organization:update"),//INVITE USERS=ADD MEMBERS
    ORGANIZATION_READ("organization:read"),//VIEW MEMBERS

    PAYMENT_CREATE("payment:create"),
    PAYMEMT_DELETE("payment:delete"),
    PAYMENT_UPDATE("payment:update"),
    PAYMENT_READ("payment:read"),

    PAYROLL_CREATE("payment:create"),
    PAYROLL_DELETE("payment:delete"),
    PAYROLL_UPDATE("payment:update"),
    PAYROLL_READ("payment:read"),

    TEAMINVOICE_CREATE("invoice:create"),
    TEAMINVOICE_DELETE("invoice:delete"),
    TEAMINVOICE_UPDATE("invoice:update"),
    TEAMINVOICE_READ("invoice:read"),


    CLIENTINVOICE_CREATE("invoice:create"),
    CLIENTINVOICE_DELETE("invoice:delete"),
    CLIENTINVOICE_UPDATE("invoice:update"),
    CLIENTINVOICE_READ("invoice:read"),


    TIMESHEET_CREATE("timesheets:create"),
    TIMESHEET_DELETE("timesheets:delete"),
    TIMESHEET_UPDATE("timesheets:update"),
    TIMESHEET_READ("timesheets:read"),
    REPORTS_CREATE("reports:create"),
    REPORTS_DELETE("reports:delete"),
    REPORTS_UPDATE("reports:update"),
    REPORTS_READ("reports:read"),






    ;



    @Getter
    private final String permission;
}
