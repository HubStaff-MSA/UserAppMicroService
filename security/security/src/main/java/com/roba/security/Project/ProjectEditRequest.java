package com.roba.security.Project;


import com.roba.security.Client.Client;

import java.util.Date;

public record ProjectEditRequest(
        Integer id,
        String projectName,
        //Budget budget,
        boolean disableActivity,
        boolean disableIdleTime,
        //Integer clientId,
        Client client,
        boolean billable,
        BudgetType budgetType,
        BudgetBasedOn budgetBasedOn,
        Double budgetCost,
        Double budgetNotifyAt,
        Date budgetStartDate,
        boolean budgetIncludeNonBillabeTime,
        Integer organizationId
) {
}