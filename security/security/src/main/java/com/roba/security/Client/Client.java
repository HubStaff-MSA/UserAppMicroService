package com.roba.security.Client;

import com.roba.security.Project.BudgetBasedOn;
import com.roba.security.Project.BudgetType;
import com.roba.security.Project.Project;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Client")
public class Client {
    @Id
    @SequenceGenerator(
            name = "client_id_sequence",
            sequenceName = "client_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_id_sequence"
    )
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @NotNull
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Project> projects;
    private String phoneNumber;
    private  String emailAddress;
    //private Budget budget;
    private boolean billable;
    private BudgetType budgetType;
    private BudgetBasedOn budgetBasedOn;
    private Double budgetCost;
    private Double budgetNotifyAt;
    private Date budgetStartDate;
    private boolean budgetIncludeNonBillabeTime;
    private Integer organizationId;
}