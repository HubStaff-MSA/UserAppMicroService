package com.roba.security.Project;



import com.roba.security.Client.Client;

import java.util.Date;

public record ProjectCreationRequest(
        String projectName,
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
        //Budget budget,
        Integer organizationId
) {
}