package com.roba.security.Project;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project {
    @Id
    @SequenceGenerator(
            name = "project_id_sequence",
            sequenceName = "project_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "project_id_sequence"
    )
    private Integer id;
    private String projectName;
    private boolean billable;
    private boolean disableActivity;
    private boolean disableIdleTime;
    private Integer clientId;
    private BudgetType budgetType;
    private BudgetBasedOn budgetBasedOn;
    private Double budgetCost;
    private Double budgetNotifyAt;
    private Date budgetStartDate;
    private boolean budgetIncludeNonBillabeTime;
}