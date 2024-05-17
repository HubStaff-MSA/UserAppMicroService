package com.roba.security.Project;



import com.roba.security.Client.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;
//import javax.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Project")
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
    // @NotNull
    private String projectName;
    private boolean disableActivity;
    private boolean disableIdleTime;
    //private Integer clientId;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    //  @NotNull
    //private Budget budget;
    private boolean billable;
    private BudgetType budgetType;
    private BudgetBasedOn budgetBasedOn;
    private Double budgetCost;
    private Double budgetNotifyAt;
    private Date budgetStartDate;
    private boolean budgetIncludeNonBillabeTime;
    // @NotNull
    private Integer organizationId;
    //members
    //users
    //managers
    //CONSTRAINTS
}