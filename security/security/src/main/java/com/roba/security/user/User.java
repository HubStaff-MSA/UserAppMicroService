package com.roba.security.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.roba.security.Project.Project;
import com.roba.security.organization.Organization;
import com.roba.security.token.Token;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name="_user")
@EqualsAndHashCode
public class User implements UserDetails, Serializable {
    @Id
    @SequenceGenerator(
            name="user_id_sequence",
            sequenceName="user_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_seqeunce"
    )
    private Integer id;
    private String fullName;
    private String workEmail;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List <Token> tokens;



    private String Department;
    private String Position;//Title


    @ManyToOne
    @JoinColumn(name="organization_id")
    // This specifies the foreign key column name in the User table

    @JsonIgnore
    private Organization organization; // Reference to organization)


    @OneToMany
    private List<Project> projects;
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
    private String PayType;//hourly/fixed
    private Integer BillRate;

    private Integer DailyLimit;
    private boolean TrackingEnabled;
    private boolean TimesheetsEnabled;
    private String Status;
   // private List<Team> teams;




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return workEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
