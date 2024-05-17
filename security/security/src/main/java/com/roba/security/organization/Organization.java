package com.roba.security.organization;

import com.roba.security.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Organization {
    @Id
    @SequenceGenerator(
            name="organization_id_sequence",
            sequenceName="organization_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "organization_id_seqeunce"
    )
    private Integer id;
    private String name;
    private String websiteURL;
    private Integer teamSize;
    private String industry;
    @OneToMany(mappedBy = "organization") // mappedBy refers to the field in User entity that owns the relationship
    private List<User> users ;


//    @OneToOne(mappedBy = "organization", cascade = CascadeType.ALL)
//    private User manager;


}
